import java.util.ArrayList;

public class _6_26_24_Balance_a_BST 
{
    static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val)
        {
            this.val = val;
            this.left = null;
            this.right = null; 
        }
    }
    public ArrayList<Integer> Al = new ArrayList<>();
    public void inorder(TreeNode root)
    {
        if(root == null)
        {
            return;
        }
        inorder(root.left);
        Al.add(root.val);
        inorder(root.right);
    }
    public TreeNode balancetree(ArrayList<Integer> Al,int start,int end)
    {
        if(start>end)
        {
            return null;
        }
        int mid = (start + end)/2;
        TreeNode root = new TreeNode(Al.get(mid));
        root.left = balancetree(Al,start,mid-1);
        root.right = balancetree(Al,mid+1,end);

        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        inorder(root);
        root = balancetree(Al,0,Al.size()-1);
        return root;
    }
    public static void main(String[] args) {
        
    }
}
