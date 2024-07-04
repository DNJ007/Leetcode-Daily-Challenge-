import java.util.*;

public class _7_4_24_Merge_Nodes_in_Between_Zeroes
{
    static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val)
        {
            this.val = val;
            this.next = null;
        }
        
    }
    
        public static ListNode mergeNodes(ListNode head) 
        {
        
            ListNode temp1 = head;
            ListNode temp2 = head.next;
            int sum = 0;
            ArrayList<Integer> AL = new ArrayList<Integer>();
    
            while(temp1!=null)
            {
                sum = 0;
                while(temp2.val!=0)
                {
                    sum += temp2.val;
                    temp2 = temp2.next;
                }
                AL.add(sum);
                temp2 = temp2.next;
                temp1 = temp2;         
            }
    
            ListNode newNode = new ListNode(AL.get(0));
            ListNode temp = newNode;
            for(int i=1;i<AL.size();i++)
            {            
                temp.next = new ListNode(AL.get(i));
                temp = temp.next;
            }
    
            return newNode;          
    }
    public static void main(String [] args)
    {
        ListNode head = new ListNode(0);
        head.next  = new ListNode(1);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);

        mergeNodes(head);
        System.out.println(); 
    }
}