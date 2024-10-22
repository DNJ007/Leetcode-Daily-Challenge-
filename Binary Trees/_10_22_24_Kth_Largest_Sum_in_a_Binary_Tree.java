import java.util.*;

public class _10_22_24_Kth_Largest_Sum_in_a_Binary_Tree 
{
    static class TreeNode {
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
    public static ArrayList<Long> levelOrderTraversal(TreeNode root)
    {
        ArrayList<Long> levelSums = new ArrayList<>();
        if(root == null)
        {
            return levelSums;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty())
        {
            long levelSize = queue.size();
            long levelSum = 0;

            for(int i=0;i<levelSize;i++)
            {
                TreeNode currentNode = queue.poll();
                levelSum += currentNode.val;
                if(currentNode.left!=null)
                {
                    queue.add(currentNode.left);
                }

                if(currentNode.right!=null)
                {
                    queue.add(currentNode.right);
                }
            }   
            levelSums.add(levelSum);         
        }
        return levelSums;
    }

    public static long kthLargestLevelSum(TreeNode root, int k) 
    {
        ArrayList<Long> Al = new ArrayList<>();
        Al = levelOrderTraversal(root);

        Collections.sort(Al,Comparator.reverseOrder());

        if(k-1 < Al.size())
            return Al.get(k-1);
        else
            return -1;
        
    }


        public static long kthLargestLevelSum2(TreeNode root, int k) 
        {
            PriorityQueue<Long> pq = new PriorityQueue<>();
    
            Queue<TreeNode> bfsQueue = new LinkedList<>();
            bfsQueue.add(root);
            while (!bfsQueue.isEmpty()) 
            {
                int size = bfsQueue.size();
                long sum = 0;
                for (int i = 0; i < size; i++) 
                {
                    TreeNode poppedNode = bfsQueue.remove();
                    sum += poppedNode.val;

                    if (poppedNode.left != null) 
                    {
                        bfsQueue.add(poppedNode.left);
                    }
                    if (poppedNode.right != null) 
                    {                        
                        bfsQueue.add(poppedNode.right);
                    }
                }
                pq.add(sum);
                if (pq.size() > k) 
                {
                    pq.remove();
                }
            }
            if (pq.size() < k) 
                return -1;

            return pq.peek();
        }
    
    public static void main(String[] args) 
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(8);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(6);

        System.out.println(kthLargestLevelSum2(root, 2));

        
    }
    
}
