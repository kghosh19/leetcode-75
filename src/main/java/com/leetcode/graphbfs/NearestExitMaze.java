package com.leetcode.graphbfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class NearestExitMaze {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;

        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});

        maze[entrance[0]][entrance[1]] = '+';

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int r = current[0];
            int c = current[1];
            int steps = current[2];

            for(int[] dir: directions) {
                int nextRow = r + dir[0];
                int nextCol = c + dir[1];

                if(nextRow >= 0 && nextRow < rows
                        && nextCol >= 0 && nextCol < cols
                        && maze[nextRow][nextCol] == '.') {

                    if (nextRow == 0 || nextRow == rows - 1 || nextCol == 0 || nextCol == cols - 1) {
                        return steps + 1;
                    }

                    maze[nextRow][nextCol] = '+';
                    queue.offer(new int[]{nextRow, nextCol, steps + 1});
                }
            }
        }

        return -1;
    }
}
