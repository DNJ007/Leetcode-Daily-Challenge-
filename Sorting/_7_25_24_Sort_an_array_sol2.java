import java.util.PriorityQueue;

public class _7_25_24_Sort_an_array_sol2 
{
    public static int[] sortArray(int[] nums) 
    {
        //Heap
        //T.C : O(n log n)
        //S.C : O(n)
       PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
       for(int i=0;i<nums.length;i++)
       {
            pq.add(nums[i]);
       }

        int i = 0;
       while(!pq.isEmpty())
       {
            nums[i++] = pq.remove();
       }
       return nums;

    }
    public static void main(String [] args)
    {
        int[] nums = {5,2,3,1};
        nums = sortArray(nums);
        for(int i=0;i<nums.length;i++)
        {
            System.out.print(nums[i]+" ");
        }
    }

    
}
