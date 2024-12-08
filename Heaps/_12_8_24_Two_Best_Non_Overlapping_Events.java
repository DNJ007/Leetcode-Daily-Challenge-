import java.util.*;
class _12_8_24_Two_Best_Non_Overlapping_Events
{
    static class element 
    {
        int start;
        int end;
        int val;

        public element(int start,int end,int val)
        {
            this.start = start;
            this.end = end;
            this.val = val;
        }
    }

    static class startTimeComparator implements Comparator<element>
    {
        @Override
        public int compare(element e1, element e2)
        {
            return Integer.compare(e1.start,e2.start);
        }
    }

    static class endTimeComparator implements Comparator<element>
    {
        @Override
        public int compare(element e1,element e2)
        {
            return Integer.compare(e1.end,e2.end);
        }
    }
        
    
    public static int maxTwoEvents(int[][] events) 
    {
        PriorityQueue<element> pq = new PriorityQueue<>(new endTimeComparator());
        ArrayList<element> Al = new ArrayList<>();

        int maxSum = 0;
        int maxSingle = 0;

        for(int[] event : events)
        {
            int start = event[0];
            int end = event[1];
            int val = event[2];

            Al.add(new element(start,end,val));
        }

        Al.sort(new startTimeComparator());

        for(element curr : Al)
        {
            while(!pq.isEmpty() && pq.peek().end < curr.start )
            {
                element top = pq.poll();
                maxSingle = Math.max(maxSingle, top.val);
            }

            maxSum = Math.max(maxSum, curr.val + maxSingle);

            pq.offer(curr);
        }

        return maxSum;

    }

    public static void main(String[] args) 
    {
       int[][] events = {{1,3,2},{4,5,2},{2,4,3}};
       System.out.println(maxTwoEvents(events));
    }
}