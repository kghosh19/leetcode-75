package com.leetcode.graphbfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int freshCount = 0;
        Queue<int[]> queue = new ArrayDeque<>();

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 2)
                    queue.offer(new int[]{i,j});
                else if(grid[i][j] == 1)
                    freshCount++;
            }
        }

        if(freshCount == 0) return 0;

        int minutes = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while(!queue.isEmpty() && freshCount > 0) {
            // Take a snapshot of the queue size for the current minute.
            // There can be multiple rotten places to start with in 2 D array.
            int size = queue.size();

            for(int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                for(int[] dir: directions) {
                    int nextRow = r + dir[0];
                    int nextCol = c + dir[1];

                    if(nextRow >= 0 && nextRow < rows
                            && nextCol >= 0 && nextCol < cols
                            && grid[nextRow][nextCol] == 1) {

                        queue.offer(new int[]{nextRow, nextCol});
                        grid[nextRow][nextCol] = 2;
                        freshCount--;
                    }
                }
            }
            minutes++;
        }
        return freshCount == 0 ? minutes : -1;
    }

}
