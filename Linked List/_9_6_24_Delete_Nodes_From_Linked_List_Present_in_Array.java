import java.util.HashSet;

public class _9_6_24_Delete_Nodes_From_Linked_List_Present_in_Array 
{
    static class ListNode 
    {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public static ListNode modifiedList(int[] nums, ListNode head) 
    {
        
        ListNode temp = new ListNode(-1);
        temp.next = head;

        ListNode curr = temp;

        HashSet<Integer> hs = new HashSet<>();

        for(int num : nums)
        {
            hs.add(num);
        }
        while(curr.next != null)
        {
            if(hs.contains(curr.next.val))
            {
                curr.next = curr.next.next;
            }
            else
            {
                curr = curr.next;
            }          
        }

        return temp.next;
    }
    public static void main(String[] args) 
    {
        int[] nums = {1,2,3};
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        head = modifiedList(nums, head);

        while(head!=null)
        {
            System.out.print(head.val+" ");
            head = head.next;  
        }
        
    }
}
