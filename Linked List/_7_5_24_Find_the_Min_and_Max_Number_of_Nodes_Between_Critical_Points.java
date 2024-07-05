import java.util.TreeMap;

public class _7_5_24_Find_the_Min_and_Max_Number_of_Nodes_Between_Critical_Points
{
    static class ListNode{
        int val;
        ListNode next;

        ListNode(int val)
        {
            this.val = val;
            this.next = null;
        }
    }
    //T.C : O(n log n)
    //S.C : O(n)
    public static int[] nodesBetweenCriticalPoints(ListNode head) 
    {
        TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();

        ListNode curr = head;
        ListNode prev = head;
        int count = 0;

        while(curr.next!=null)
        {
            if(count == 0)
            {
                curr = curr.next;
                count++;
                continue;
            }
            
            if(curr.val > prev.val && curr.val > curr.next.val)
            {
                int value = curr.val;
                tm.put(count,value);
            }

            if(curr.val < prev.val && curr.val < curr.next.val)
            {
                int value = curr.val;
                tm.put(count,value);
            }           
            
            count++;
            prev = prev.next;
            curr = curr.next;
        }

        if(count <= 1 || tm.size() <= 1)
        {
            return new int[]{-1,-1};
        }

        int maxd = 0;
        int mind = Integer.MAX_VALUE;
        
        maxd = tm.lastKey() - tm.firstKey();

        if(tm.size() == 2)
        {
            return new int[]{maxd,maxd};
        }

        int idx = 0;
        int prevIdxVal = 0;

        for(int num : tm.keySet())
        {
            if(idx == 0)
            {
                idx++;
                prevIdxVal = num;
                continue;
            }

            mind = Math.min(mind,num - prevIdxVal);
            prevIdxVal = num;
        }
        
        return new int[]{mind,maxd};
    }
    public static void main(String [] args)
    {
        //5,3,1,2,5,1,2

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