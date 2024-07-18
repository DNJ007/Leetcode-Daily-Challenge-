import java.util.*;

public class _7_18_24_Number_of_Good_Leaf_Nodes_Pairs 
{
    public static class TreeNode 
    {
                 int val;
                 TreeNode left;
                 TreeNode right;
                 TreeNode() {}
                 TreeNode(int val) { this.val = val; }
                 TreeNode(int val, TreeNode left, TreeNode right) {
                     this.val = val;
                     this.left = left;
                     this.right = right;
                 }
    }
    public static void creategraph(TreeNode root, TreeNode prev, HashMap<TreeNode, ArrayList<TreeNode>> graph, HashSet<TreeNode> hs)
    {
        
        if(root == null)
        {
            return;
        }

        if(root.left == null && root.right == null)
        {
            hs.add(root);
        }

        if(prev != null)
        {
            graph.putIfAbsent(root, new ArrayList<>());
            graph.putIfAbsent(prev, new ArrayList<>());
            graph.get(root).add(prev);
            graph.get(prev).add(root);
        }

        creategraph(root.left,root, graph,hs);
        creategraph(root.right,root, graph,hs);
    }

    public static int bfs(TreeNode leaf,int distance,HashSet<TreeNode> hs,HashMap<TreeNode, ArrayList<TreeNode>> graph)
    {
        Queue<TreeNode> q = new LinkedList<>();
        Map<TreeNode,Integer> visited = new HashMap<>();
        q.add(leaf);
        visited.put(leaf, 0);

        int pairs = 0;
        while(!q.isEmpty())
        {
            TreeNode node = q.poll();
            int dist = visited.get(node);

            if(dist > distance)
            {
                continue;
            }

            if(dist > 0 && hs.contains(node))
            {
                pairs++;
            }

            for(TreeNode neighbour : graph.getOrDefault(node, new ArrayList<>()))
            {
                if(!visited.containsKey(neighbour))
                {
                    visited.put(neighbour, dist+1);
                    q.add(neighbour);
                }
            }
        }
        return pairs;
    }
    public static int countPairs(TreeNode root, int distance) 
    {
        HashMap<TreeNode, ArrayList<TreeNode>> graph = new HashMap<>(); 
        HashSet<TreeNode> hs = new HashSet<TreeNode>();

        creategraph(root,null,graph,hs);
        
        int count = 0;

        for(TreeNode leaf : hs)
        {
            count += bfs(leaf,distance,hs,graph);
        }

        return count/2;
        
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(countPairs(root, 3));
    }
}
