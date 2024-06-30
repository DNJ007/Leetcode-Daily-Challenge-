import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _6_29_All_Ancestors_of_a_Node_in_a_Directed_Acyclic_Graph {
    public List<List<Integer>> getAncestors(int n, int[][] edges) 
    {
        List<Integer>[] adjacencyList = new ArrayList[n];
        for(int i=0;i<n;i++)
        {
            adjacencyList[i] = new ArrayList<>();
        }

        for(int[] edge : edges)
        {
            int from = edge[0];
            int to = edge[1];
            adjacencyList[to].add(from);
        }

        List<List<Integer>> ancestorsList = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            List<Integer> ancestors = new ArrayList<>();
            Set<Integer> visited = new HashSet<>();

            findChildren(i, adjacencyList, visited);

            for(int node = 0; node < n; node++)
            {
                if(node == i)
                    continue;
                if(visited.contains(node))
                    ancestors.add(node);
            }
            ancestorsList.add(ancestors);
        }
        return ancestorsList;
    }

    private void findChildren(int currentNode, List<Integer>[] adjacencyList, Set<Integer> visitedNodes)
    {
        visitedNodes.add(currentNode);

        for(int neighbour : adjacencyList[currentNode])
        {
            if(!visitedNodes.contains(neighbour))
            {
                findChildren(neighbour, adjacencyList, visitedNodes);
            }
        }
    }
}
