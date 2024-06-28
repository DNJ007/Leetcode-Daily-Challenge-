import java.util.ArrayList;
import java.util.Collections;
public class _6_25_24_Greater_sum_tree
{
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
            this.left = null;
            this.right = null; 
        }
    }

    public static ArrayList<Integer> Al = new ArrayList<>();
    static int count = 0;

    public static void reverseInorder(Node root)
    {
        if(root == null)
        {
            return;
        }
        reverseInorder(root.right);
        Al.add(root.data);
        reverseInorder(root.left);
    }

    public static void Modifiedinorder(Node root)
    {
        if(root == null)
        {
            return;
        }

        Modifiedinorder(root.left);
        root.data = Al.get(count++); 
        Modifiedinorder(root.right);
    }

    public static void inorderprint(Node root)
    {
        if(root == null)
        {
            return;
        }

        inorderprint(root.left);
        System.out.print(root.data+" " );        
        inorderprint(root.right);
    }

    public static void main(String [] args)
    {
        Node root = new Node(4);
        root.left = new Node(1);
        root.left.left = new Node(0);
        root.left.right = new Node(2);
        root.left.right.right = new Node(3);

        root.right = new Node(6);
        root.right.left = new Node(5);
        root.right.right = new Node(7);
        root.right.right.right = new Node(8);
        reverseInorder(root);

        for(int i=0;i<Al.size();i++)
        { 
            System.out.print(Al.get(i)+" ");
        }
        System.out.println();

        int sum = 0;
        for(int i=0;i<Al.size()-1;i++)
        {   
            sum = 0;
            System.out.print(Al.get(i)+" ");
            sum = Al.get(i) + Al.get(i+1);
            Al.set(i+1,sum);
        } 

        Collections.reverse(Al);
        System.out.println();

        for(int i=0;i<Al.size();i++)
        { 
            System.out.print(Al.get(i)+" ");
        }

        Modifiedinorder(root);
        System.out.println();
        inorderprint(root);
    }
}