import java.util.Arrays;

public class _7_26_24_Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance_FloydWarshall
{ 
    static public void floydWarshall(int n, int[][]SPM)
    {
        for(int via = 0; via < n; via++)
        {
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n; j++)
                {   
                    if (SPM[i][via] != Integer.MAX_VALUE && SPM[via][j] != Integer.MAX_VALUE) {
                        SPM[i][j] = Math.min(SPM[i][j], SPM[i][via] + SPM[via][j]);
                    }
                }
            }
        }
    }
    public static int findresultCity(int n, int[][] SPM, int d)
    {
        int resultCity = -1;
        int leastReachCount = Integer.MAX_VALUE;

        for(int i=0;i<n;i++)
        {
            int countReach = 0;
            for(int j=0;j<n;j++)
            {
                if(i!=j && SPM[i][j] <=d)
                {
                    countReach++;
                }
            }
            if(countReach <= leastReachCount)
            {
                leastReachCount = countReach;
                resultCity = i;
            }
        }
         return resultCity;
    }
    public static int findTheCity(int n, int[][] edges, int distanceThreshold) 
    {        
        int [][] SPM = new int[n][n];
        for (int[] row : SPM) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for(int i=0;i<n;i++)
        {
            SPM[i][i] = 0;
        }

        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            SPM[u][v] = wt;
            SPM[v][u] = wt;
        }

        floydWarshall(n,SPM);

        return findresultCity(n,SPM,distanceThreshold);
    }     

    public static void main(String [] args)
    {
        int n = 4;
        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold = 4;
        System.out.println(findTheCity(n, edges, distanceThreshold));  
    }
}