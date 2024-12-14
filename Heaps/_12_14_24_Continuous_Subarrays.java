import java.util.*;
public class _12_14_24_Continuous_Subarrays 
{
    static class element implements Comparable<element>
    {
        int num;
        int idx;

        element(int num,int idx)
        {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(element e2)
        {
            return Integer.compare(this.num,e2.num);
        }

    }
    public static long continuousSubarrays(int[] nums) 
    {
        PriorityQueue<element> minHeap = new PriorityQueue<element>();
        PriorityQueue<element> maxHeap = new PriorityQueue<element>(Comparator.reverseOrder());
        int j = 0;
        int i = 0;
        long count = 0;
        while(j<nums.length)
        {
            minHeap.add(new element(nums[j],j));
            maxHeap.add(new element(nums[j],j));

            while(!minHeap.isEmpty() && !maxHeap.isEmpty() && Math.abs(maxHeap.peek().num - minHeap.peek().num) > 2)
            {
                i++;
                
                while(minHeap.peek().idx < i && !minHeap.isEmpty())
                {
                    minHeap.poll();
                }
                while(maxHeap.peek().idx< i && !maxHeap.isEmpty())
                {
                    maxHeap.poll();
                }
            }

            count += j-i+1;

            j++;
        }
        return count;
    }
    public static void main(String[] args) 
    {
        int[]nums = {5,4,2,4};
        System.out.println(continuousSubarrays(nums));
        
    }
}
