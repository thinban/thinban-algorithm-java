package com.thinban.array;


import cn.hutool.core.lang.Console;

public class MatrixReshape {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int or = mat.length, oc = mat[0].length;
        if (r == oc && c == oc || r * c != or * oc) return mat;
        int[][] res = new int[r][c];
        for (int i = 0; i < or; i++) {
            for (int j = 0; j < oc; j++) {
                int t = i * oc + j;
                res[t / c][t % c] = mat[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 2}, {3, 4}};
        int[][] ints = new MatrixReshape().matrixReshape(mat, 1, 4);
        Console.log(ints);
    }
}
