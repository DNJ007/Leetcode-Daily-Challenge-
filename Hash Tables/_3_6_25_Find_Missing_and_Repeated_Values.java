public class _3_6_25_Find_Missing_and_Repeated_Values 
{
    public static int[] findMissingAndRepeatedValues(int[][] grid) 
    {
        int n = grid.length;
        int[] freq = new int[n*n+1];
        int[] res = new int[2];
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(freq[grid[i][j]] == 1)
                {
                    res[0] = grid[i][j];
                }
                freq[grid[i][j]]++;
            }
        }        
       
        for(int i=1;i<=n*n;i++)
        {
            if(freq[i] == 0)
            {
                res[1] = i;
                break;
            }
        }       
        return res;
    }

    public static void main(String[] args) 
    {
        int[][] grid = {{9,1,7},{8,9,2},{3,4,6}};
       int[] res = findMissingAndRepeatedValues(grid);   
       System.out.println(res[0]+" "+res[1]);             
    }   
}
