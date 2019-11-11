package com.sonu.datastructures.Arrays;

public class Array {

    public int[][] compliment(int[][] a) {
        int[][] res = new int[a[0].length][a.length];
        int row = a.length;
        int column = a[0].length;

        for(int i=0; i<row; i++) {
            for(int j=0; j<column; j++) {
                res[j][i] = a[i][j];
            }
        }
        return res;
    }

    public void print(int[][] a) {
        int rows = a.length;
        int columns = a[0].length;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<columns; j++) {
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}
