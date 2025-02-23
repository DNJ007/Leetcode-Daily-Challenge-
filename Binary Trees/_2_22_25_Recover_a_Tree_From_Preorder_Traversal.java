public class _2_22_25_Recover_a_Tree_From_Preorder_Traversal 
{
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    private static int n;
    
    private static TreeNode solve(String traversal, int[] index, int depth) {
        if (index[0] >= n) {
            return null;
        }
        
        int j = index[0];
        while (j < n && traversal.charAt(j) == '-') {
            j++;
        }
        
        int dash = j - index[0];
        
        if (depth != dash) {
            return null;
        }
        
        index[0] += dash;
        
        int value = 0;
        while (index[0] < n && Character.isDigit(traversal.charAt(index[0]))) {
            value = value * 10 + (traversal.charAt(index[0]) - '0');
            index[0]++;
        }
        
        TreeNode root = new TreeNode(value);
        root.left = solve(traversal, index, depth + 1);
        root.right = solve(traversal, index, depth + 1);
        
        return root;
    }
    
    public static TreeNode recoverFromPreorder(String traversal) {
        n = traversal.length();
        int[] index = {0}; // Using an array to pass by reference
        return solve(traversal, index, 0);
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

    public static void main(String[] args) {
        String s = "1-401--349---90--88";
        TreeNode root = recoverFromPreorder(s);
        inorder(root);
    }
    
}
