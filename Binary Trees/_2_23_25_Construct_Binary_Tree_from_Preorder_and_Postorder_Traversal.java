public class _2_23_25_Construct_Binary_Tree_from_Preorder_and_Postorder_Traversal {
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

    public static TreeNode solve(int preStart, int postStart, int preEnd, int[] preorder, int[] postorder) {
        if (preStart > preEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) {
            return root;
        }
        int nextNode = preorder[preStart + 1];

        int j = postStart;

        while (postorder[j] != nextNode) {
            j++;
        }

        int num = j - postStart + 1;

        root.left = solve(preStart + 1, postStart, preStart + num, preorder, postorder);
        root.right = solve(preStart + num + 1, j + 1, preEnd, preorder, postorder);

        return root;
    }

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) 
    {
        int n = preorder.length;
        return solve(0, 0, n - 1, preorder, postorder);
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

    public static void main(String[] args) 
    {
        int[] preorder = {1,2,4,5,3,6,7};
        int[] postorder = {4,5,2,6,7,3,1};
        TreeNode root = constructFromPrePost(preorder, postorder);
        inorder(root);
    }
}