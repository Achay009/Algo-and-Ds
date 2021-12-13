package com.company;

public class NumberOfIsland {
    public static void markIsland(int [][] grid, int i, int j, int row, int column)
    {
        if (i < 0 || i >= row || j < 0 || j >= column || grid[i][j] != 1) return;

        grid[i][j] = 2;
        markIsland(grid, i+1, j, row, column); //DOWN
        markIsland(grid, i, j+1, row, column); //RIGHT
        markIsland(grid, i-1, j, row, column); //UP
        markIsland(grid, i, j-1, row, column); //LEFT
    }

    public static int numberOfIsland(int[][]grid)
    {

        int row = grid.length;
        int column = grid[0].length;
        int numberOfIsland = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < column; j++){
                if (grid[i][j] == 1){
                    markIsland(grid, i, j, row, column);
                    numberOfIsland++;
                }
            }
        }
        return numberOfIsland;
    }
}
