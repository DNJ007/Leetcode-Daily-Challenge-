import java.util.Comparator;
import java.util.PriorityQueue;

public class _12_12_24_Take_Gifts_From_the_Richest_Pile 
{
    public static long pickGifts(int[] gifts, int k) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int num : gifts)
        {
            pq.add(num);
        }

        while(k>0)
        {
            int largestnum = pq.poll();
            int num = (int) Math.sqrt(largestnum);
            pq.add(num);
            k--;
        }
        long sum = 0;
        while(!pq.isEmpty())
        {
            sum += pq.poll();
        }
        return sum;

    }

    public static void main(String[] args) {
        int[] gifts = {25,64,9,4,100};
        int k = 4;
        System.out.println(pickGifts(gifts,k));
    }
}
