public class _7_4_24_Merge_Nodes_in_Between_Zeroes_Much_Optimized 
{
    static class ListNode
    {
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
        ListNode head1 = new ListNode();
        ListNode temp = head1;
        ListNode temp1 = head;
        ListNode temp2 = head.next;
        int sum = 0;

        while(temp1!=null)
        {
            sum = 0;
            while(temp2.val!=0)
            {
                sum += temp2.val;
                temp2 = temp2.next;
            }
            
            if(sum != 0)
            {
                temp.next = new ListNode(sum);
                temp = temp.next;
            }
           
            temp2 = temp2.next;
            temp1 = temp2;         
        }
        return head1.next;        
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
