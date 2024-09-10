public class _9_10_24_Insert_Greatest_Common_Divisors_in_Linked_List
{
    public static class ListNode 
    {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static int gcd(int a,int b)
    {
        int result = Math.min(a, b);
        while (result > 0) 
        {
            if (a % result == 0 && b % result == 0) 
            {
                break;
            }
            result--;
        }
        return result;
    }
    public static ListNode insertGreatestCommonDivisors(ListNode head) 
    {
        ListNode prev = head;
        ListNode curr = head.next;

        while(curr!=null)
        {
            ListNode newNode = new ListNode(gcd(prev.val,curr.val));

            prev.next = newNode;
            newNode.next = curr;

            prev = curr;
            curr = curr.next;
        }

        return head;        
    }
    public static void main(String [] args)
    {
        ListNode head = new ListNode(18);
        head.next = new ListNode(6);
        head.next.next = new ListNode(10);
        head.next.next.next = new ListNode(3);
        head = insertGreatestCommonDivisors(head);
        
        while(head!=null)
        {
            System.out.print(head.val+"->");
            head = head.next;
        }
        System.out.println("null");
    }
}