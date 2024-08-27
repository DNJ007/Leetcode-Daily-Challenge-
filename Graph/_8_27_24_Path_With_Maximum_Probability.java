import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class _8_27_24_Path_With_Maximum_Probability
{
    static class Node
    {
        int node;
        double prob;

        Node(int node,double prob)
        {
            this.node = node;
            this.prob = prob;
        }
    }
    public static double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) 
    {
        List<List<Node>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++)
        {
            int[] edge = edges[i];
            adj.get(edge[0]).add(new Node(edge[1],succProb[i]));
            adj.get(edge[1]).add(new Node(edge[0],succProb[i]));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> -Double.compare(a.prob,b.prob));
        double[] dist = new double[n];

        dist[start_node] = 1;

        pq.add(new Node(start_node, 1));
        while(!pq.isEmpty())
        {
            Node curr = pq.remove();
            for(Node nbr : adj.get(curr.node))
            {
                if(curr.prob * nbr.prob > dist[nbr.node])
                {
                    dist[nbr.node] = curr.prob * nbr.prob;
                    pq.add(new Node(nbr.node, dist[nbr.node]));
                }
            }
        }

        return dist[end_node];

    }
    public static void main(String [] args)
    {
        int n = 3;
        int[][] edges = {{0,1},{1,2},{0,2}};
        double[] succProb = {0.5,0.5,0.2};
        int start = 0, end = 2;
        System.out.println(maxProbability(n, edges, succProb, start, end)); 
    }
}