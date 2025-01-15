/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package week2;

import validation.Validation;

/**
 *
 * @author bong
 */
public class Matrix {

    Validation validation = new Validation();

    private int numRow;
    private int numColumn;
    private double[][] matrix;

    public Matrix() {
    }

    public Matrix(int numRow, int numColumn) {
        this.numRow = numRow;
        this.numColumn = numColumn;
        this.matrix = new double[numRow][numColumn] ;
    }

    public void setNumRow(int numRow) {
        this.numRow = numRow;
    }

    public void setNumColumn(int numColumn) {
        this.numColumn = numColumn;
    } 

    public int getNumRow() {
        return numRow;
    }

    public int getNumColumn() {
        return numColumn;
    }

    public void inputMatrix(String matrixName) {
        for (int i = 0; i < this.numRow; i++) {
            for (int j = 0; j < this.numColumn; j++) {
                this.matrix[i][j] = validation.getValidDouble("Enter "+matrixName+"[" + (i+1) + "][" + (j+1) + "]: ");
            }
        }
    }
    
     public void validateDimensions(Matrix other) {
        if (this.numRow != other.numRow || this.numColumn != other.numColumn) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for this operation.");
        }
    }
    
    public Matrix add(Matrix other) {
        validateDimensions(other);
        Matrix result = new Matrix(this.numRow, this.numColumn) {};
        for (int i = 0; i < this.numRow; i++) {
            for (int j = 0; j < this.numColumn; j++) {
                result.matrix[i][j] = this.matrix[i][j] + other.matrix[i][j];
            }
        }
        return result;
    }

    public Matrix subtract(Matrix other) {
        validateDimensions(other);
        Matrix result = new Matrix(this.numRow, this.numColumn) {};
        for (int i = 0; i < this.numRow; i++) {
            for (int j = 0; j < this.numColumn; j++) {
                result.matrix[i][j] = this.matrix[i][j] - other.matrix[i][j];
            }
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        if (this.numColumn != other.numRow) {
            throw new IllegalArgumentException("Number of columns of the first matrix must equal the number of rows of the second matrix.");
        }
        Matrix result = new Matrix(this.numRow, other.numColumn) {};
        for (int i = 0; i < this.numRow; i++) {
            for (int j = 0; j < other.numColumn; j++) {
                for (int k = 0; k < this.numColumn; k++) {
                    result.matrix[i][j] += this.matrix[i][k] * other.matrix[k][j];
                }
            }
        }
        return result;
    }
    
    public void display() {
        for (double[] row : matrix) {
            for (double value : row) {
                System.out.print("["+value + "] ");
            }
            System.out.println();
        }
    }
    
}

