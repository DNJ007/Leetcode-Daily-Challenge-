import java.util.*;
public class _10_29_24_Maximum_Number_of_Moves_in_a_Grid
{
    private static final int[] dirs = {-1,0,1};

    public static int maxMoves(int[][] grid) 
    {
        int M = grid.length;
        int N = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[M][N];

        for(int i=0;i<M;i++)
        {
            vis[i][0] = true;
            q.offer(new int[] {i,0,0});
        }

        int maxMoves = 0;

        while(!q.isEmpty())
        {
            int sz = q.size();

            while(sz-- > 0)
            {
                int[] v = q.poll();

                int row = v[0], col = v[1], count = v[2];

                maxMoves = Math.max(maxMoves,count);

                for(int dir : dirs)
                {
                    int newRow = row + dir, newCol = col + 1;

                    if( newRow >= 0 && newCol >= 0 && newRow < M 
                    && newCol < N && !vis[newRow][newCol] 
                    && grid[row][col] < grid[newRow][newCol])
                    {
                        vis[newRow][newCol] = true;
                        q.offer(new int[] {newRow, newCol, count+1});
                    }
                }
            }
        }
        return maxMoves;
    }

    public static int DFS(int row,int col, int[][] grid,int[][] dp)
    {
        int m= grid.length;
        int n= grid[0].length;
        int moves = 0;

        if(dp[row][col]!=-1)
        {
            return dp[row][col];
        }
        for(int dir : dirs)
        {
            int newRow = row+dir;
            int newCol = col+1;

            if(newRow >= 0 && newRow < m &&  newCol >= 0 && newCol < n && grid[newRow][newCol] > grid[row][col])
            {
                moves = Math.max(moves, 1 + DFS(newRow,newCol,grid,dp));
            }
        }
        return dp[row][col]=moves;
    }
    public static int maxMoves2(int[][] grid) 
    {
        int m= grid.length;
        int n= grid[0].length;
        int res = 0;

        int dp[][] = new int[m+1][n+1];
        for(int row[] : dp)
        {
            Arrays.fill(row,-1);
        }
        for(int row=0;row<m;row++)
        {
            res = Math.max(res,DFS(row,0,grid,dp));
        }

        return res;
    }
    public static void main(String [] args)
    {
        int[][]grid = {{2,4,3,5},{5,4,9,3},{3,4,2,11},{10,9,13,15}};
        System.out.println(maxMoves2(grid)); 
    }
}
