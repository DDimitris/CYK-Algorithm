/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CYKalgorithm;

import Utils.Cell;
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
        System.out.println(numOfColumns + " " + numOfRows);
        List<Cell> startCell = matrix[numOfColumns - 1][0];
        for (Cell cell : startCell) {
            printRecurr(cell, 0, null);
            break;
        }
    }

    private void printRecurr(Cell cell, int depth, Boolean isLeft) {
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
        if (matrix[cell.getLeftChild().getX()][cell.getLeftChild().getY()] != null) {
            printRecurr(matrix[cell.getLeftChild().getX()][cell.getLeftChild().getY()].get(0), depth + 1, true);
        }
        if (matrix[cell.getRightChild().getX()][cell.getRightChild().getY()] != null) {
            printRecurr(matrix[cell.getRightChild().getX()][cell.getRightChild().getY()].get(0), depth + 1, false);
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
