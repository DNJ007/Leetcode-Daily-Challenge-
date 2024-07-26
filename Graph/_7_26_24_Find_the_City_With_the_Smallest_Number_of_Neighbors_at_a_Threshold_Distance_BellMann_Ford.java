import java.util.Arrays;

public class _7_26_24_Find_the_City_With_the_Smallest_Number_of_Neighbors_at_a_Threshold_Distance_BellMann_Ford 
{
    static class edge implements Comparable<edge>
    {
        int dest;
        int wt;

        public edge(int dest,int wt)
        {
            this.dest = dest;
            this.wt = wt;
        }

        @Override
        public int compareTo(edge e2)
        {
            return this.wt - e2.wt;
        }

    }
    public static void bellmanford(int n,int[][] edges,int[] result,int src)
    {
        //T.C : O(V^4)
        Arrays.fill(result,Integer.MAX_VALUE);
        result[src] = 0;

        for(int i=1;i<n;i++)
        {
            for(int[] edge : edges)
            {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];

                if(result[u]!=Integer.MAX_VALUE && result[u] + wt <  result[v])
                {
                    result[v] = result[u] + wt;
                }

                if(result[v]!=Integer.MAX_VALUE && result[v] + wt <  result[u])
                {
                    result[u] = result[v] + wt;
                }
            }
        }

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

        for(int i=0;i<n;i++)
        {
            bellmanford(n, edges, SPM[i], i);
        }

        return findresultCity(n,SPM,distanceThreshold);
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

    public static void main(String[] args) 
    {
        int n = 4;
        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold = 4;
        System.out.println(findTheCity(n, edges, distanceThreshold)); 

    }     
}
