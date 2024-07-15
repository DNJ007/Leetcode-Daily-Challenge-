import java.util.HashMap;
import java.util.HashSet;

public class _7_15_24_Create_Binary_Tree_From_Descriptions
{
    public static class TreeNode {
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
    public static TreeNode createBinaryTree(int[][] descriptions) 
    {       
        //T.C : O(n)
        //S.C : O(n)
        HashMap<Integer,TreeNode> hm = new HashMap<>();
        HashSet<Integer> hs = new HashSet<>();

        for(int i=0; i<descriptions.length ; i++)
        {
            int parent = descriptions[i][0];
            int child = descriptions[i][1];
            int isLeft = descriptions[i][2];

            if(!hm.containsKey(parent))
            {
                hm.put(parent,new TreeNode(parent));
            }

            if(!hm.containsKey(child))
            {
                hm.put(child,new TreeNode(child));
            }

            if(isLeft == 1)
            {
                hm.get(parent).left = hm.get(child);
            }
            else
            {
                hm.get(parent).right = hm.get(child);
            }

            hs.add(child);
        }

        for(int i=0 ; i<descriptions.length  ;i++)
        {
            int parent = descriptions[i][0];
            if(!hs.contains(parent))
            {
                return hm.get(parent);
            }
        }
        return null;
    }

    public static void inorder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }

        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);

    }
    public static void main(String [] args)
    {
        int[][] descriptions = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        TreeNode root = createBinaryTree(descriptions); 
        inorder(root);
    }
}