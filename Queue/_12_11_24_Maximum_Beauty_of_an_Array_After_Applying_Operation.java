import java.util.*;
public class _12_11_24_Maximum_Beauty_of_an_Array_After_Applying_Operation 
{
    static class Pair implements Comparable<Pair>
    {
        int start;
        int end;

        Pair(int start,int end)
        {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair p2)
        {
            return Integer.compare(this.start,p2.start);
        }
    }
    public static int maximumBeauty(int[] nums, int k) 
    {
        ArrayList<Pair> Al = new ArrayList<>();

        for(int num : nums)
        {
            Al.add(new Pair(num-k,num+k));
        }
        Collections.sort(Al);
        // for(int i=0;i<Al.size();i++)
        //     System.out.println(Al.get(i).start +" " +Al.get(i).end);

        Deque<Pair> dq = new LinkedList<>();

        dq.addFirst(Al.get(0));

        for(int i=1;i<Al.size();i++)
        {
            if(dq.peek().end >= Al.get(i).start)
            {
                dq.addLast(Al.get(i));
            }
            else
            {
                dq.removeFirst();
                dq.addLast(Al.get(i));
            }
        }
        return dq.size();
        
    }
    
}
