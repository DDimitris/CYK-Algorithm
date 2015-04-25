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

    private CellPoint x;
    private CellPoint y;
    private String thisCellValue;
    private boolean isDiagonal;

    public Cell(CellPoint x, CellPoint y, String thisCellValue, boolean isDiagonal) {
        this.x = x;
        this.y = y;
        this.thisCellValue = thisCellValue;
        this.isDiagonal = isDiagonal;
    }

    public CellPoint getX() {
        return x;
    }

    public void setX(CellPoint x) {
        this.x = x;
    }

    public CellPoint getY() {
        return y;
    }

    public void setY(CellPoint y) {
        this.y = y;
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

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.x);
        hash = 23 * hash + Objects.hashCode(this.y);
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
        if (!Objects.equals(this.x, other.x)) {
            return false;
        }
        if (!Objects.equals(this.y, other.y)) {
            return false;
        }
        if (!Objects.equals(this.thisCellValue, other.thisCellValue)) {
            return false;
        }
        return true;
    }
}
