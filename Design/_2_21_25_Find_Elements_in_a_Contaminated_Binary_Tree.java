import java.util.HashSet;

public class _2_21_25_Find_Elements_in_a_Contaminated_Binary_Tree 
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
    public static HashSet<Integer> hs = new HashSet<>();
    public static void dfs(TreeNode root, int x)
    {
        if(root == null)
        {
            return;
        }
        root.val = x;
        hs.add(x);
        dfs(root.left,2*root.val+1);
        dfs(root.right,2*root.val+2);
    }
    public _2_21_25_Find_Elements_in_a_Contaminated_Binary_Tree(TreeNode root) 
    {
        dfs(root,0);
    }
    
    public boolean find(int target) 
    {
        if(hs.contains(target))
        {
            return true;
        }

        return false;
    }
    public static void main(String[] args) 
    {
        TreeNode root = new TreeNode(-1);
        root.left = new TreeNode(-1);
        root.right = new TreeNode(-1);
        root.left.left = new TreeNode(-1);
        root.left.right = new TreeNode(-1);
        _2_21_25_Find_Elements_in_a_Contaminated_Binary_Tree findElements = new _2_21_25_Find_Elements_in_a_Contaminated_Binary_Tree(root);
        System.out.println(findElements.find(1));
        System.out.println(findElements.find(3));
        System.out.println(findElements.find(5));
        
    }
}
