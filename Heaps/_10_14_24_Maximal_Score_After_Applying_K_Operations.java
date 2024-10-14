import java.util.Collections;
import java.util.PriorityQueue;

public class _10_14_24_Maximal_Score_After_Applying_K_Operations
{
    public static long maxKelements(int[] nums, int k) 
    {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        long score = 0;

        for(int i : nums)
        {
            pq.add(i);
        }

        while(k>0)
        {
            int val = pq.poll();
            score += val;
            val =(int) Math.ceil(val/3.0);
            pq.add(val);
            k--;
        }

        return score;
        
    }
    public static void main(String [] args)
    {
        int[] nums = {1,10,3,3,3};
        int k = 3;
        System.out.println(maxKelements(nums, k)); 
    }
}