import java.util.*;
public class _2_13_25_Minimum_Operations_to_Exceed_Threshold_Value_II 
{
    public static int minOperations(int[] nums, int k) 
    {
        PriorityQueue<Long> pq= new PriorityQueue<>();

        for(int num:nums)
        {
            pq.add((long)num);
        }

        int ans = 0;
        while(!pq.isEmpty() && pq.peek()<k && pq.size() >=2)
        {
            long x = pq.poll();       
            long y = pq.poll();
            long z = Math.min(x,y)*2+Math.max(x,y);
            
            pq.add(z);
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) 
    {
        int[] nums = {2,11,10,1,3};
        int k = 10;

        System.out.println(minOperations(nums, k));
        
    }
    
}
