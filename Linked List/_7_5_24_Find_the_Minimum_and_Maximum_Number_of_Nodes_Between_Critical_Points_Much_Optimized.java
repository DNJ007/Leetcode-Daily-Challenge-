public class _7_5_24_Find_the_Minimum_and_Maximum_Number_of_Nodes_Between_Critical_Points_Much_Optimized{
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val)
        {
            this.val = val;
            this.next = null;
        }
    }
    //T.C : O(n)
    //S.C : O(1)
    public static int[] nodesBetweenCriticalPoints(ListNode head) 
    {
        int first = -1,pcp = -1,i=1,min = Integer.MAX_VALUE;
        ListNode node = head,prev = null;

        while(node!=null)
        {
            if(prev!=null && node.next!=null)
            {
                if((prev.val > node.val && node.next.val > node.val) ||
                    (prev.val < node.val && node.next.val < node.val))
                    {
                        if(pcp!=-1)
                        {
                            min = Math.min(min,i-pcp);
                        }
                        if(first == -1)
                        {
                            first = i;
                        }
                        pcp = i;
                    }               
            }
            prev = node;
            node = node.next;
            i++;
        }

        if(first == -1 || first == pcp)
        {
            return new int[]{-1,-1};
        }

        int max = pcp - first;

        return new int[]{min,max};
    }
    public static void main(String [] args)
    {
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(2);

        int[] arr = nodesBetweenCriticalPoints(head);
        
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }

        System.out.println();
    }
}