import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class _12_20_24_Reverse_Odd_levels_of_Binary_Tree 
{
    static class TreeNode 
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
    public static void solve(TreeNode L,TreeNode R,int level)
    {
        if(L == null)
            return;

        if(R == null)
            return;
            
        if(level % 2 == 1)
        {
            int temp = L.val;
            L.val = R.val;
            R.val = temp;
        }

        solve(L.left,R.right,level+1);
        solve(L.right,R.left,level+1);
    }
    public static TreeNode reverseOddLevelsDFS(TreeNode root) 
    {
        solve(root.left,root.right,1);
        return root;
    }

    public static void preorder(TreeNode root)
    {
        if(root == null)
            return;
        
        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
        
    }

    public static TreeNode reverseOddLevelsBFS(TreeNode root) 
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        int level = 0;

        while(!q.isEmpty())
        {
            int n = q.size();

            ArrayList<TreeNode> levelNodes = new ArrayList<>();

            while(n-- > 0)
            {
                TreeNode temp = q.poll();
                levelNodes.add(temp);

                if(temp.left != null)
                {
                    q.add(temp.left);
                }
                if(temp.right != null)
                {
                    q.add(temp.right);
                }
            }

            if(level%2 == 1)
            {
                int i = 0;
                int j = levelNodes.size()-1;

                while(i<j)
                {
                    int tempVal = levelNodes.get(i).val;
                    levelNodes.get(i).val = levelNodes.get(j).val;
                    levelNodes.get(j).val = tempVal;
                    i++;
                    j--;
                }
            }
            level++;
        }
        return root;
    }

    public static void main(String[] args) 
    {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(13);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(34);
        
        preorder(root);
        System.out.println();
        reverseOddLevelsDFS(root);
        preorder(root);

        preorder(root);
        System.out.println();
        reverseOddLevelsBFS(root);
        preorder(root);
    }
    
}
