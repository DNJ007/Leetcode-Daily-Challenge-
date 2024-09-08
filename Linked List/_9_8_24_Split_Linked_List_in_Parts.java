public class _9_8_24_Split_Linked_List_in_Parts 
{
    public static  class ListNode 
    {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static  ListNode[] splitListToParts(ListNode head, int k) 
    {
        ListNode[] ans = new ListNode[k];
        int length = 0;
        ListNode temp = head;

        while(temp!=null)
        {
            length++;
            temp = temp.next;
        }

        temp = head;
        int size = length/k;
        int extra = length%k;

        for(int i=0;i<=k;i++)
        {
            if(temp == null)
            {
                break;
            }
            ans[i] = temp;
            ListNode prev = null;
            for(int j=0;j<size;j++)
            {
                prev = temp;
                temp = temp.next;
            }
            if(extra > 0)
            {
                prev = temp;
                temp = temp.next;
                extra -= 1;
            }
            prev.next = null;
        }

        return ans;        
    }

    public static void main(String[] args) 
    {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next.next = new ListNode(10);

        ListNode node[] = splitListToParts(head, 3);

        //print all elements
        for (int i = 0; i < node.length; i++) 
        {
            ListNode curr = node[i];
            System.out.print("Part " + (i + 1) + ": ");
            while (curr != null) 
            {
                System.out.print(curr.val + " ");
                curr = curr.next;
            }
            System.out.println();
        }

        
    }
    
}
