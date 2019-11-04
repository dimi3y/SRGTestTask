package com.dco.ds;

import lombok.Getter;
import lombok.Setter;

import java.util.Random;

public class Matrix {

    @Getter
    @Setter
    private int n;

    @Getter
    @Setter
    private int[][] matrix;

    public Matrix(int n) {
        this.n = n;
        matrix = new int[n][n];
    }

    public void generateMatrix() {
        Random r = new Random();

        for(int i = 0; i < n - 1; i++) {
            for(int j = i; j < n; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = r.nextInt(2) * r.nextInt(40);
                    matrix[j][i] = matrix[i][j];
                }
            }
        }
    }

    public void printMatrix() {
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.printf("%3s", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
