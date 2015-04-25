/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CYKalgorithm;

import CNFParser.Parser;
import Utils.Cell;
import Utils.CellPoint;
import Utils.Rule;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Dimitris Dedousis <dimitris.dedousis@gmail.com>
 */
public class CΥΚalgorithm {

    private List<Cell>[][] matrix;
    private Parser parser;
    private Map<String, String> lexicon;
    private List<Rule<String, String, String>> rules;
    private int col;
    private int row;
    private boolean isAboveTheDiagonal = false;

    public CΥΚalgorithm(Parser parser) {
        this.parser = parser;
        this.lexicon = parser.getLexicon();
        this.rules = parser.getListOfRules();
    }

    public void runAlgorithm(String sentence) {
        initializeTable(sentence);
        for (int i = 1; i < col; i++) {
            for (int j = row - 1; j >= 0; j--) {
                if (isAboveTheDiagonal) {
                    System.out.println("Cell: " + i + ", " + j);
                    fillCell(i, j);
                } else {
                    if (matrix[i][j] != null) {
                        isAboveTheDiagonal = true;
                        continue;
                    }
                }
            }
            isAboveTheDiagonal = false;
        }
    }

    private void fillCell(int col, int row) {
        int cellCounter = 1;
        int middle;
        boolean isActive = true;
        matrix[col][row] = new ArrayList();
        while (isActive) {
            middle = col - cellCounter;
            System.out.println("Cheking [ " + col + " , " + middle + " ]" + " , [ " + middle + " , " + row + " ]");
            List<Cell> cellOnY = matrix[col][middle];
            List<Cell> cellOnX = matrix[middle][row];
            if (cellOnX != null && cellOnY != null) {
                for (Cell terminalOnX : cellOnX) {
                    for (Cell terminalOnY : cellOnY) {
                        for (Rule rule : rules) {
                            if (rule.getFirstSymbol().equals(terminalOnX.getThisCellValue()) && rule.getSecondSymbol().equals(terminalOnY.getThisCellValue())) {
                                matrix[col][row].add(new Cell(new CellPoint(middle, row), new CellPoint(col, middle), (String) rule.getNonTerminalSymbol(), false, null));
//                                isActive = false;
                            }
                        }
                    }
                }
            }
            cellCounter++;
            if (matrix[middle][row] != null && !matrix[middle][row].isEmpty() && matrix[middle][row].get(0).isIsDiagonal()) {
                break;
            }
        }
    }

    private void initializeTable(String sentence) {
        String[] split = sentence.split(" ");
        //width = col
        //height = row
        col = split.length + 1;
        row = split.length;
        //Each cell [i,j] contains a set of non-terminals
        matrix = new ArrayList[split.length + 1][split.length];
        System.out.println("Sentence length: " + split.length);
        System.out.println("Matrix length: " + matrix.length);
        for (int i = 1; i < col; i++) {
            matrix[i][i - 1] = new ArrayList<>();
            String get = lexicon.get(split[i - 1]);
            Cell cell = new Cell(new CellPoint(0, 0), new CellPoint(0, 0), get, true, split[i - 1]);
            matrix[i][i - 1].add(cell);
        }
    }

    /**
     * All cells in this array is type of ArrayList. Given this certain
     * algorithm some cells are null. So if you try to iterate and get the
     * values of cells that were not initialized before, you get null pointer
     * exception.
     */
    public void printMatrix() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[j][i] == null) {
                    System.out.print("null\t\t");
                    continue;
                }
                if (matrix[j][i].size() > 1) {
                    for (Cell cell : matrix[j][i]) {
                        System.out.print(cell.getThisCellValue() + " ");
                        System.out.print("[" + cell.getLeftChild().getX() + "," + cell.getLeftChild().getY() + "] [");
                        System.out.print(cell.getRightChild().getX() + "," + cell.getRightChild().getY() + "]");
                    }
                    System.out.print("\t\t");
                } else if (matrix[j][i].size() == 1) {
                    System.out.print(matrix[j][i].get(0).getThisCellValue() + " [");
                    System.out.print(matrix[j][i].get(0).getLeftChild().getX() + " , " + matrix[j][i].get(0).getLeftChild().getY() + "] , [");
                    System.out.print(matrix[j][i].get(0).getRightChild().getX() + " , " + matrix[j][i].get(0).getRightChild().getY() + "]\t\t");

                } else {
                    System.out.print("null\t\t");
                }
            }
            System.out.println();
        }
    }

    public int getNumOfColumns() {
        return col;
    }

    public int getNumOfRows() {
        return row;
    }

    public List<Cell>[][] getMatrix() {
        return matrix;
    }
}
