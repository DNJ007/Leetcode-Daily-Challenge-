public class _9_7_24_Linked_list_in_Binary_Tree 
{
        public static class ListNode 
        {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
         }
        
        public static class TreeNode 
        {
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
    public static boolean isSubPath(ListNode head, TreeNode root) 
    {
        if(head == null) return true;
        if(root == null) return false;

        if(head.val == root.val)
        {
            if(solve(head.next,root.right) || solve(head.next, root.left))
            {
                return true;
            }
        }

        if(isSubPath(head,root.right)) return true;
        if(isSubPath(head,root.left)) return true;
        
        return false;
    }

    private static boolean solve(ListNode head, TreeNode root)
    {
        if(head == null) return true;
        if(root == null || head.val != root.val) return false;

        return solve(head.next, root.left) || solve(head.next, root.right);
    }

    public static void main(String[] args) 
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(8);
        root.right.left.right.left = new TreeNode(1);
        root.right.left.right.right = new TreeNode(2);
        
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(8);

        System.out.println(isSubPath(head, root));
    }
    
}
