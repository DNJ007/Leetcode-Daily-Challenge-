import java.util.*;

public class _3_22_25_Count_the_Number_of_Complete_Components
{
    public static void dfs(int i,HashMap<Integer,ArrayList<Integer>> hm,boolean[] vis,int [] count)
    {
        vis[i] = true;
        count[0]++;
        count[1] += hm.get(i).size();

        for(int neighbor : hm.get(i))
        {
            if(!vis[neighbor])
            {
                dfs(neighbor,hm,vis,count);
            }
        }
    }
    public static int countCompleteComponents(int n, int[][] edges) 
    {
        HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();

        int res = 0;
        for (int i = 0; i < n; i++) 
        {
            hm.put(i, new ArrayList<>());
        }

        for(int[] edge : edges)
        {
            int u = edge[0];
            int v = edge[1];    
            
            hm.get(u).add(v);
            hm.get(v).add(u);
        } 

        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(vis[i] == true)
            {
                continue;
            }

            int[] count = new int[2]; 
            dfs(i, hm, vis, count);

            int v = count[0];
            int e = count[1] / 2;
           

            if(v*(v-1)/2 == e)
            {
                res++;
            }
        }   
        return res;    
    }
    public static void main(String [] args)
    {
        int n = 6;
        int[][] edges = {{0,1},{0,2},{1,2},{3,4}};
        System.out.println(countCompleteComponents(n, edges)); 
    }
}