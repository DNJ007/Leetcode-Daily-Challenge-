import java.util.PriorityQueue;

public class _3_26_25_Minimum_Operations_to_Make_a_Uni_Value_Grid
{
    public static int minOperations(int[][] grid, int x) 
    {
        if(grid.length == 1 && grid[0].length==1) return 0;
        int n = grid.length * grid[0].length;
        int halfsize = n/2; 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<grid.length;i++)    
        {
            for(int j=0;j<grid[0].length;j++)
            {
                pq.add(grid[i][j]);
            }
        }    
        while(halfsize-- > 0)
        {
            pq.poll();
        }
        int UnivalueNum = 0;
        if(!pq.isEmpty())
            UnivalueNum = pq.peek();
        int ops = 0;
        for(int i=0;i<grid.length;i++)    
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j] == UnivalueNum) continue;
                int y = Math.abs(UnivalueNum - grid[i][j]);
                if((y%x) == 0)
                {
                    ops += y/x;
                }
                else
                {
                    return -1;
                }                
            }
        }   
        return ops;
    }
    public static void main(String [] args)
    {
        int[][]grid = {{2,4},{6,8}};
        int x = 2;
        System.out.println(minOperations(grid, x)); 
    }
}