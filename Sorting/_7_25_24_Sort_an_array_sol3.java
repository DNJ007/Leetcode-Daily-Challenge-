import java.util.TreeMap;

public class _7_25_24_Sort_an_array_sol3 
{
    public static int[] sortArray(int[] nums) 
    {
      //Counting Sort
      //T.C : O(n log n)
      //S.C : O(n)
      TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();

      for(int i=0;i<nums.length;i++)
      {
        tm.put(nums[i],tm.getOrDefault(nums[i],0)+1);
      }

      int i = 0;
      for(int num : tm.keySet())
      {
        int count = tm.get(num);
        while(count!=0)
        {
            nums[i++] = num;
            count--;
        }
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
