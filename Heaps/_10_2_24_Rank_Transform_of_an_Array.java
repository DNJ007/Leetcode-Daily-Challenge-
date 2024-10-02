import java.util.PriorityQueue;

public class _10_2_24_Rank_Transform_of_an_Array
{
    static class Object implements Comparable<Object>
    {        
        int val;
        int index;

        public Object(int val,int index)
        {
            this.val = val;
            this.index = index;
        }

        @Override
        public int compareTo(Object o2)
        {
            return Integer.compare(this.val,o2.val);
        }
    }
    public static int[] arrayRankTransform(int[] arr) 
    {
        if (arr.length == 0) return arr;
        PriorityQueue<Object> pq = new PriorityQueue<Object>();
        for(int i=0;i<arr.length;i++)
        {
            pq.add(new Object(arr[i],i));
        }

        int r = 1;
        Object prev = pq.poll();
        arr[prev.index] = r;

        while(!pq.isEmpty())
        {
            Object curr = pq.poll();
            if(curr.val != prev.val)
            {                
                r++;
            } 
            arr[curr.index] = r; 
            prev = curr;          
        }

        return arr;
    }
    public static void main(String [] args)
    {
        int[] arr = {37,12,28,9,100,56,80,5,12};
        arr = arrayRankTransform(arr);
        for(int i=0;i<arr.length;i++)
            System.out.print(arr[i]+" "); 
    }
}