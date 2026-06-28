package com.leetcode.hashmaporset;

import java.util.HashMap;
import java.util.Map;

public class EqualRowColPair {

    public int equalPairs(int[][] grid) {

        int n  = grid.length;
        int count = 0;

        Map<String, Integer> rowFreqMap = new HashMap<>();
        for(int i = 0; i < n; i++) {
            StringBuilder rowString = new StringBuilder();
            for (int j = 0; j < grid[0].length; j++) {
                rowString.append(grid[i][j]).append(",");
            }
            String rStr = rowString.toString();
            rowFreqMap.put(rStr, rowFreqMap.getOrDefault(rStr, 0) + 1);
        }

        for(int i = 0; i < n; i++) {
            StringBuilder colString = new StringBuilder();
            for (int j = 0; j < n; j++) {
                colString.append(grid[j][i]).append(",");
            }
            String cStr = colString.toString();
            count += rowFreqMap.getOrDefault(cStr, 0);
        }


        return count;
    }

    public static void main(String[] args) {
        EqualRowColPair solution = new EqualRowColPair();

        // Test case 1: 3x3 matrix
        int[][] grid1 = {
            {3, 2, 1},
            {1, 7, 6},
            {2, 7, 7}
        };
        System.out.println("Grid 1:");
        printMatrix(grid1);
        System.out.println("Equal pairs: " + solution.equalPairs(grid1));
        System.out.println();

        // Test case 2: 2x2 matrix
        int[][] grid2 = {
            {3, 1},
            {1, 3}
        };
        System.out.println("Grid 2:");
        printMatrix(grid2);
        System.out.println("Equal pairs: " + solution.equalPairs(grid2));
        System.out.println();

        // Test case 3: 4x4 matrix
        int[][] grid3 = {
            {1, 2, 3, 4},
            {2, 3, 4, 1},
            {3, 4, 1, 2},
            {4, 1, 2, 3}
        };
        System.out.println("Grid 3:");
        printMatrix(grid3);
        System.out.println("Equal pairs: " + solution.equalPairs(grid3));
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
