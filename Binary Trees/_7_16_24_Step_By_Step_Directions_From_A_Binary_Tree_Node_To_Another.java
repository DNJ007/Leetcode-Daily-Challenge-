public class _7_16_24_Step_By_Step_Directions_From_A_Binary_Tree_Node_To_Another
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
    public static TreeNode lca(TreeNode root,int n1,int n2)
    {
        if(root == null)
        {
            return null;
        }
        if(root.val == n1 || root.val == n2)
        {
            return root;
        }

        TreeNode leftlca = lca(root.left,n1,n2);
        TreeNode rightlca = lca(root.right,n1,n2);

        if(rightlca == null)
        {
            return leftlca;
        }
        if(leftlca == null)
        {
            return rightlca;
        }
        return root;
    }

    public static boolean findPath(TreeNode node, int target, StringBuilder path)
    {
        if (node == null)
        {
            return false;
        }

        if (node.val == target)
        {
            return true;
        }

        path.append('L');
        if (findPath(node.left, target, path))
        {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if (findPath(node.right, target, path))
        {
            return true;
        }
        path.deleteCharAt(path.length() - 1);

        return false;
    }
    public static String getDirections(TreeNode root, int startValue, int destValue) 
    {
        //T.C : O(n)
        //S.C : O(n)
        TreeNode LCA = lca(root,startValue,destValue);

        StringBuilder lcaToSrc = new StringBuilder("");
        StringBuilder lcaToDest = new StringBuilder("");

        findPath(LCA, startValue, lcaToSrc);
        findPath(LCA, destValue, lcaToDest);

        StringBuilder res =  new StringBuilder("");

        for(int i=0;i<lcaToSrc.length();i++)
        {
            res.append('U');
        }

        return res.append(lcaToDest).toString();
    }
    public static void main(String [] args)
    {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(4);

        System.out.println(getDirections(root, 3, 6)); 
    }
}
