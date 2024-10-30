import java.util.*;
public class _10_27_24_Count_Sqaure_Submatrices_with_All_Ones
{
    public static int solve(int i, int j, int[][] grid, int[][] dp) {
        // If the cell lies outside the grid, return 0.
        if (i >= grid.length || j >= grid[0].length) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }

        // If we have already visited this cell, return the memoized value.
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Find the answer for the cell to the right of the current cell.
        int right = solve(i, j + 1, grid, dp);
        // Find the answer for the cell to the diagonal of the current cell.
        int diagonal = solve(i + 1, j + 1, grid, dp);
        // Find the answer for the cell below the current cell.
        int below = solve(i + 1, j, grid, dp);

        return dp[i][j] = 1 + Math.min(right, Math.min(diagonal, below));
    }

    public static int countSquares(int[][] grid) {
        int ans = 0;
        int[][] dp = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Arrays.fill(dp[i], -1);
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ans += solve(i, j, grid, dp);
            }
        }

        return ans;
    }
    public static void main(String [] args)
    {
        int matrix[][] =
            {
            {0,1,1,1},
            {1,1,1,1},
            {0,1,1,1}};
        System.out.println(countSquares(matrix)); 
    }
}