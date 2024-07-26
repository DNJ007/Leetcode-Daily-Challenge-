import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class _7_26_24_Find_City_With_the_Smallest_Number_at_Threshold_Distance_Dijkstra
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
    public static void dijkstra(int n,HashMap<Integer,ArrayList<edge>> adj,int[] SPM,int src)
    {
        //T.C : O(V^3 * log E)
        PriorityQueue<edge> pq = new PriorityQueue<edge>();
        pq.add(new edge(src,0));
        SPM[src] = 0;

        while(!pq.isEmpty())
        {
            edge e = pq.poll();
            int dest = e.dest;
            int wt = e.wt;

            for(edge neighbor : adj.get(dest))
            {
                int newDist = wt + neighbor.wt;

                if(newDist < SPM[neighbor.dest])
                {
                    SPM[neighbor.dest] = newDist;
                    pq.add(new edge(neighbor.dest, newDist));
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

        HashMap<Integer,ArrayList<edge>> adj = new HashMap<Integer,ArrayList<edge>>();
        for (int i = 0; i < n; i++) {
            adj.put(i, new ArrayList<>());
        }

        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new edge(v,wt));
            adj.get(v).add(new edge(u,wt));
        }

        for(int i=0;i<n;i++)
        {
            dijkstra(n, adj, SPM[i], i);
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

    public static void main(String [] args)
    {
        int n = 4;
        int[][] edges = {{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold = 4;
        System.out.println(findTheCity(n, edges, distanceThreshold)); 

        int n1 = 5;
        int edges1[][] = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        int distanceThreshold1 = 2;
        System.out.println(findTheCity(n1, edges1, distanceThreshold1));
    }
}