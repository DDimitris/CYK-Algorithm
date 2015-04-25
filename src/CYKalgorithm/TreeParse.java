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
    public void printTree(){
        List<Cell> startCell = matrix[numOfColumns][numOfRows];
        for(Cell cell : startCell){
            
        }
    }
}
