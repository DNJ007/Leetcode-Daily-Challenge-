import java.util.*;

public class _10_23_24_Cousins_in_Binary_Tree_II 
{
    public class TreeNode 
    {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) 
             {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
    }

    public static TreeNode replaceValueInTree(TreeNode root) 
    {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        int previousLevelSum = root.val;

        while (!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size();
            int currentLevelSum = 0;

            for (int i = 0; i < levelSize; i++) 
            {
                TreeNode currentNode = nodeQueue.poll();
                currentNode.val = previousLevelSum - currentNode.val;

                int siblingSum =
                    (currentNode.left != null ? currentNode.left.val : 0) +
                    (currentNode.right != null ? currentNode.right.val : 0);

                if (currentNode.left != null) 
                {
                    currentLevelSum += currentNode.left.val; 
                    currentNode.left.val = siblingSum; 
                    nodeQueue.offer(currentNode.left); 
                }
                if (currentNode.right != null) 
                {
                    currentLevelSum += currentNode.right.val; 
                    currentNode.right.val = siblingSum; 
                    nodeQueue.offer(currentNode.right); 
                }
            }

            previousLevelSum = currentLevelSum; 
        }
        return root;
    }
    
}
