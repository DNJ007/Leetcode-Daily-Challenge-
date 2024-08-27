import java.util.Arrays;

public class _8_14_24_Find_Kth_Smallest_Pair_Distance 
{
    public int smallestDistancePair(int[] nums, int k) 
    {
        int n = nums.length;
        Arrays.sort(nums);
    
        int max = nums[n - 1] - nums[0];

        int[] freq = new int[max+1];
        Arrays.fill(freq,0);

        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                int num = Math.abs(nums[i]-nums[j]);
                freq[num]++;
            }           
        }

        int count = 0;
        for(int i=0;i<freq.length;i++)
        {
            count += freq[i];

            if(count >= k)
            {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) 
    {
        int[] nums = {1,6,1};
        int k = 3;
        System.out.println(smallestDistancePair(nums, k));
        
    }
    
}
