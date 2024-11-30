import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Stack;

public class _11_30_24_Valid_Agreements_of_Pairs
{
    public static int[][] validArrangement(int[][] pairs) 
    {
        HashMap<Integer, LinkedList<Integer>> adj = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>(),
        outdegree = new HashMap<>();

        for(int[] pair : pairs)
        {
            int u = pair[0];
            int v = pair[1];

            adj.putIfAbsent(u, new LinkedList<>());
            adj.get(u).add(v);

            outdegree.put(u,outdegree.getOrDefault(u, 0)+1);
            indegree.put(v,indegree.getOrDefault(v, 0)+1);
        }
        
       

        int startNode = -1;
        for (int node : outdegree.keySet()) 
        {
            if (outdegree.get(node) == indegree.getOrDefault(node, 0) + 1) 
            {
                startNode = node;
                break;
            }
        }

        if (startNode == -1) {
            startNode = pairs[0][0];
        }


        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        s.push(startNode);

        while(!s.empty())
        {
            int node = s.peek();

            if(adj.getOrDefault(node,new LinkedList<>()).size() > 0)
            {
                int nextNode = adj.get(node).removeFirst();
                s.push(nextNode);
            }
            else
            {
                result.add(node);
                s.pop();
            }
        }

        Collections.reverse(result);

        int[][] pairedResult = new int[result.size()-1][2];

        for(int i=1;i<result.size();++i)
        {
            pairedResult[i-1][0] = result.get(i-1);
            pairedResult[i-1][1] = result.get(i);
        }

        return pairedResult;
        
    }
    public static void main(String [] args)
    {
        int[][] pairs = {{5,1},{4,5},{11,9},{9,4}};
        pairs = validArrangement(pairs);
        
        for(int i=0;i<pairs.length;i++)
        {            
            System.out.print("["+pairs[i][0]+", "+pairs[i][1]+"], ");
        }
    }
}