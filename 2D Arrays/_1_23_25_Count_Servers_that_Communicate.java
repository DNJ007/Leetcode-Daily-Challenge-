public class _1_23_25_Count_Servers_that_Communicate 
{
    public static int countServers(int[][] grid) 
    {    
        int rows = grid.length;
        int cols = grid[0].length;
    
        int[] rowCount = new int[rows];
        int[] colCount = new int[cols];
        
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < cols; j++) 
            {
                if (grid[i][j] == 1) 
                {
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < rows; i++) 
        {
            for (int j = 0; j < cols; j++) 
            {
                if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) 
                {
                    count++;
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) 
    {
        int[][]grid = {{1,1,0,0},{0,0,1,0},{0,0,1,0},{0,0,0,1}};
        System.out.println(countServers(grid));
        
    }
    
}
