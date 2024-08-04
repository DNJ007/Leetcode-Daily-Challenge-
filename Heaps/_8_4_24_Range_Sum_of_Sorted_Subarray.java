import java.util.PriorityQueue;

public class _8_4_24_Range_Sum_of_Sorted_Subarray
{
    private static final int MOD = 1_000_000_007;
    public static int rangeSum(int[] nums, int n, int left, int right) 
    {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> (a[0]-b[0]));

        for(int i=0;i<n;i++)
        {
            minHeap.offer(new int[]{nums[i],i});
        }

        int res = 0;

        for(int i=1;i<=right;i++)
        {
            int[] pair = minHeap.poll();

            if(i>=left)
            {
                res = (res + pair[0]) %MOD;
            }
            if(pair[1] < n-1)
            {
                pair[1]++;
                pair[0] = (pair[0] + nums[pair[1]]) % MOD;
                minHeap.offer(pair);
            }
        }
        return res;
    }
    public static void main(String [] args)
    {
        int[] nums = {1,2,3,4};
        int n = 4, left = 1, right = 5;
        System.out.println(rangeSum(nums, n, left, right)); 
    }
}