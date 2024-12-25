import java.util.*;

public class _12_25_24_Find_Largest_Value_in_Each_Tree_Row 
{
    static class TreeNode 
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

    public static List<Integer> largestValues(TreeNode root) 
    {
        Queue<TreeNode> q = new LinkedList<>();
        if(root != null)
            q.add(root);

        
        List<Integer> res = new ArrayList<>();

        if(root != null)
            res.add(root.val);

        while(!q.isEmpty())
        {
            int n = q.size();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            while(n-- > 0)
            {
                TreeNode temp = q.poll();

                if(temp.left != null)
                {
                    q.add(temp.left);
                    pq.add(temp.left.val);
                }
                if(temp.right != null)
                {
                    q.add(temp.right);
                    pq.add(temp.right.val);
                }
            }

            if(!pq.isEmpty())
            {
                res.add(pq.poll());
            }
        }
        return res;
    }

    public static void main(String[] args) 
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(9);

        System.out.println(largestValues(root));
        
    }
    
}
