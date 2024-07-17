import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class _7_17_24_Delete_Nodes_And_Retrn_Forest 
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
    public static TreeNode deleteHelper(TreeNode root, HashSet<Integer> hs,List<TreeNode> result)
    {
        if(root == null)
        {
            return null;
        }

        root.left = deleteHelper(root.left, hs, result);
        root.right = deleteHelper(root.right, hs, result);

        if(hs.contains(root.val))
        {
            if(root.left != null)
            {
                result.add(root.left);
            }
            if(root.right != null)
            {
                result.add(root.right);
            }
            return null;
        }
        else
        {
            return root;
        }

    }
    public  static List<TreeNode> delNodes(TreeNode root, int[] to_delete) 
    {
        List<TreeNode> result = new ArrayList<TreeNode>();
        HashSet<Integer> hs = new HashSet<>();
        for(int i : to_delete)
        {
            hs.add(i);
        }

        deleteHelper(root, hs, result);

        if(!hs.contains(root.val))
        {
            result.add(root);
        }
        return result;
    }

    public static void preOrderPrint(TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        preOrderPrint(node.left);
        preOrderPrint(node.right);
    }

    public static void main(String[] args) 
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        int[] to_delete = {3,5};

        List<TreeNode> res = delNodes(root, to_delete);
        
        for (TreeNode tree : res) {
            preOrderPrint(tree);
            System.out.println(); 
        }
        
    }
}
