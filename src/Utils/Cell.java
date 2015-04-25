/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.util.Objects;

/**
 *
 * @author Dimitris Dedousis <dimitris.dedousis@gmail.com>
 */
public class Cell {

    private CellPoint leftChild;
    private CellPoint rightChild;
    private String thisCellValue;
    private boolean isDiagonal;
    private String thisCellWord;

    public Cell(CellPoint leftChild, CellPoint rightChild, String thisCellValue, boolean isDiagonal, String thisCellWord) {
        this.leftChild = leftChild;
        this.rightChild = rightChild;
        this.thisCellValue = thisCellValue;
        this.isDiagonal = isDiagonal;
        this.thisCellWord = thisCellWord;
    }

    public CellPoint getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(CellPoint x) {
        this.leftChild = x;
    }

    public CellPoint getRightChild() {
        return rightChild;
    }

    public void setRightChild(CellPoint y) {
        this.rightChild = y;
    }

    public String getThisCellValue() {
        return thisCellValue;
    }

    public void setThisCellValue(String thisCellValue) {
        this.thisCellValue = thisCellValue;
    }

    public boolean isIsDiagonal() {
        return isDiagonal;
    }

    public void setIsDiagonal(boolean isDiagonal) {
        this.isDiagonal = isDiagonal;
    }

    public String getThisCellWord() {
        return thisCellWord;
    }

    public void setThisCellWord(String thisCellWord) {
        this.thisCellWord = thisCellWord;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.leftChild);
        hash = 23 * hash + Objects.hashCode(this.rightChild);
        hash = 23 * hash + Objects.hashCode(this.thisCellValue);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Cell other = (Cell) obj;
        if (!Objects.equals(this.leftChild, other.leftChild)) {
            return false;
        }
        if (!Objects.equals(this.rightChild, other.rightChild)) {
            return false;
        }
        if (!Objects.equals(this.thisCellValue, other.thisCellValue)) {
            return false;
        }
        return true;
    }
}
