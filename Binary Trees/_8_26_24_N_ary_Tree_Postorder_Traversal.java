import java.util.ArrayList;
import java.util.List;

public class _8_26_24_N_ary_Tree_Postorder_Traversal
{
    static class Node 
    {
        public int val;
        public List<Node> children;

        public Node() {
            children = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<>();
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void postOrder(Node currentNode, List<Integer> postorderList)
    {
        if (currentNode == null) {
            return;
        }

        for (Node childNode : currentNode.children) {
            postOrder(childNode, postorderList);
        }

        postorderList.add(currentNode.val);
    }

    public static List<Integer> postorder(Node root) 
    {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        postOrder(root, result);
        return result;
    }

    public static void main(String[] args)
    {
        
        Node root = new Node(1);
        root.children.add(new Node(3));
        root.children.add(new Node(2));
        root.children.add(new Node(4));

        
        root.children.get(0).children.add(new Node(5));
        root.children.get(0).children.add(new Node(6));

        
        System.out.println(postorder(root)); 
    }
}
