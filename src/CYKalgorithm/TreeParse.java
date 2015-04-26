/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CYKalgorithm;

import Utils.Cell;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dimitris Dedousis <dimitris.dedousis@gmail.com>
 */
public class TreeParse {

    private int numOfColumns;
    private int numOfRows;
    private List<Cell>[][] matrix;

    public TreeParse(int numOfColumns, int numOfRows, List<Cell>[][] matrix) {
        this.numOfColumns = numOfColumns;
        this.numOfRows = numOfRows;
        this.matrix = matrix;
    }

    public void printTree() {
        List<Cell> startCell = matrix[numOfColumns - 1][0];
        int counter = 1;
        for (Cell c : startCell) {
            List<Cell> hack = new ArrayList<>();
            hack.add(c);
            System.out.println("\n<----- Tree " + counter + " ----->\n");
            counter++;
            printRecurr(hack, 0, null);
        }
    }

    @SuppressWarnings("unchecked")
    private void printRecurr(List<Cell> cells, int depth, Boolean isLeft) {
        Cell cell = null;
        for (Cell c : cells) {
            if (c.isIsUsed() && cells.size() > 1) {
                continue;
            } else {
                cell = c;
                break;
            }
        }
        System.out.print("|");
        for (int i = 0; i <= depth; i++) {
            System.out.print("-");
        }
        if (isLeft == null) {
            System.out.print(cell.getThisCellValue());
        } else if (!isLeft) {
            System.out.print(cell.getThisCellValue() + " Right");
        } else {
            System.out.print(cell.getThisCellValue() + " Left");
        }
        System.out.println();
        cell.setIsUsed(true);
        if (matrix[cell.getLeftChild().getX()][cell.getLeftChild().getY()] != null) {
            printRecurr(matrix[cell.getLeftChild().getX()][cell.getLeftChild().getY()], depth + 1, true);
        }
        if (matrix[cell.getRightChild().getX()][cell.getRightChild().getY()] != null) {
            printRecurr(matrix[cell.getRightChild().getX()][cell.getRightChild().getY()], depth + 1, false);
        }
    }
    /*
     * printRecurr(node, depth):
     print(depth * " ")
     ptint(node)
     if node.first != null:
     printRecurr(node.first, depth+1)
     if node.second != null:
     printRecurr(node.second, depth+1)
     */
}
