import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _7_21_24_Build_Matrix_with_Conditions 
{
    //T.C : O(K^2)
    //S.C : O(K^2)
    public static int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) 
    {
        List<Integer> topoRow = topoSort(rowConditions,k);
        List<Integer> topoCol = topoSort(colConditions,k);

        if(topoRow.isEmpty() || topoCol.isEmpty())
        {
            return new int[0][0];
        }
        int[][] matrix = new int[k][k];
        for(int i=0;i<k;i++)
        {
            for(int j=0;j<k;j++)
            {
               if (topoRow.get(i).equals(topoCol.get(j))) {
                    matrix[i][j] = topoRow.get(i);
                }
            }            
        } 
        return matrix;       
    }

    private static List<Integer> topoSort(int[][] edges,int n)
    {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] edge :edges)
        {
            adj.get(edge[0]).add(edge[1]);
        }

        List<Integer> order = new ArrayList<>();

        int[] visited = new int[n+1];
        boolean[] hasCycle = {false};

        for(int i=1;i<=n;i++)
        {
            if(visited[i] == 0)
            {
                dfs(i,adj,visited,order,hasCycle);
                if(hasCycle[0])
                {
                    return new ArrayList<>();
                }
            }
        }

        Collections.reverse(order);
        return order;
    }

    private static void dfs(int node,List<List<Integer>> adj,int[] visited, List<Integer> order, boolean[] hasCycle)
    {
        visited[node] = 1;

        for(int neighbor : adj.get(node))
        {
            if(visited[neighbor] == 0)
            {
                dfs(neighbor, adj, visited, order, hasCycle);

                if(hasCycle[0])
                {
                    return;
                }
            }
            else if(visited[neighbor] == 1)
            {
                hasCycle[0] = true;
                return;
            }            
        }

        visited[node] = 2;
        order.add(node);
    }

    public static void main(String[] args) 
    {
        int k = 3;
        int[][] rowConditions = {{1,2},{3,2}}, colConditions = {{2,1},{3,2}};
        int[][] matrix = buildMatrix(k, rowConditions, colConditions);

        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
