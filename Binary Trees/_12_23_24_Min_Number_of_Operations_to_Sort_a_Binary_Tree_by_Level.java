import java.util.*;

public class _12_23_24_Min_Number_of_Operations_to_Sort_a_Binary_Tree_by_Level 
{
    static class TreeNode 
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
    public static int countMinSwapsToSort(ArrayList<Integer> Al)
    {   
        HashMap<Integer,Integer> hm = new HashMap<>();
        ArrayList<Integer> sortedAl = new ArrayList<>(Al);
        Collections.sort(sortedAl);
        for(int i=0;i<Al.size();i++)
        {
            hm.put(Al.get(i),i);
        }

        int swaps = 0;
        for(int i=0;i<Al.size();i++)
        {
            if(Al.get(i)==sortedAl.get(i))
            {
                continue;
            }

            int currIdx = hm.get(sortedAl.get(i));
            hm.put(Al.get(i),currIdx);
            Al.set(currIdx,Al.get(i));
            Al.set(i,Al.get(currIdx));
            swaps++;
        }
        
        return swaps;
    }
    public static int minimumOperations(TreeNode root) 
    {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0;

        while(!q.isEmpty())
        {
            int n = q.size();

            ArrayList<Integer> levelNodes = new ArrayList<>();


            while(n-- > 0)
            {
                TreeNode temp = q.poll();
                levelNodes.add(temp.val);

                if(temp.left != null)
                {
                    q.add(temp.left);
                }
                if(temp.right != null)
                {
                    q.add(temp.right);
                }
            }

            res += countMinSwapsToSort(levelNodes);
        }
        return res;
    }

    public static void main(String[] args) 
    {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(6);
        root.left.left = new TreeNode(7);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(5);
        root.right.left.left = new TreeNode(9);
        root.right.right.left = new TreeNode(10);
        
        System.out.println(minimumOperations(root));
    }
    
}
