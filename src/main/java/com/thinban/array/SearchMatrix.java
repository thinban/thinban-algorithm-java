package com.thinban.array;

import com.thinban.base.Ut;

/**
 * 有序矩阵搜搜
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] > target) {
                break;
            }
            if (matrix[i][matrix[i].length - 1] < target) {
                continue;
            }
            int col = Ut.binarySearch(matrix[i], target);
            if (col != -1) {
                return true;
            }
        }
        return false;
    }

    /**
     * 右上角开始遍历
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix2(int[][] matrix, int target) {
        int row = 0;
        int col = matrix.length - 1;
        while (row < matrix.length && col >= 0) {
            if (target > matrix[row][col]) {
                row++;
            } else if (target < matrix[row][col]) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }
}
