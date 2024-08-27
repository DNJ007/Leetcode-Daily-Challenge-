import java.util.ArrayList;
import java.util.List;

public class _8_25_24_Binary_Tree_Postorder_Traversal 
{
    static class TreeNode 
    {
            int val;
            TreeNode left;
            TreeNode right;
            TreeNode() {}
            TreeNode(int val) 
            { 
                this.val = val; 
            }
            TreeNode(int val, TreeNode left, TreeNode right) 
            {
                this.val = val;
                 this.left = left;
                 this.right = right;
            }
    }
    public static List<Integer> Al = new ArrayList<Integer>();
    public static void postOrder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }

        postOrder(root.left);       
        postOrder(root.right);
         Al.add(root.val);
        
    }
    public static List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return Al;
    }

    public static void main(String[] args) 
    {
       // root = [1,null,2,3]
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = postorderTraversal(root);
        System.out.println(result);

    }
    
}
