import java.util.Comparator;
import java.util.PriorityQueue;

public class _6_23_24_Longest_Continuous_Subarray_With_Absolute_Diff_less_than_or_equal_to_limit
{
    public static int longestSubarray(int[] nums, int limit) 
    {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b)->b[0]-a[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a[0]));

        int left = 0, maxLength = 0;

        for(int right=0;right < nums.length;++right)
        {
            maxHeap.offer(new int[]{ nums[right], right });
            minHeap.offer(new int[]{ nums[right], right });

            while(maxHeap.peek()[0] - minHeap.peek()[0] > limit)
            {
                left = Math.min(maxHeap.peek()[1],minHeap.peek()[1])+1;

                while(maxHeap.peek()[1] < left)
                {
                    maxHeap.poll();
                }
                while(minHeap.peek()[1] <left)
                {
                    minHeap.poll();
                }                
            }

            maxLength = Math.max(maxLength, right-left+1);
        }
        return maxLength;
    }
    public static void main(String [] args)
    {
        int []nums = {8,2,4,7};
        int limit = 4;
        System.out.println(longestSubarray(nums, limit)); 
    }
}