public class _3_19_25_Minimum_Operations_to_Make_Binary_Array_Elements_Equal_to_One_I 
{
    public static int minOperations(int[] nums) 
    {
        int count = 0;
        for(int i=0;i<nums.length-2;i++)
        {
            if(nums[i] == 1) continue;
            
            for(int j=i;j<=i+2;j++)
            {
                nums[j] = nums[j]^1;
            }
            count++;
        }

        if(nums[nums.length-1]==0 || nums[nums.length-2]==0)
            return -1;

        return count;
    }

    public static void main(String[] args) 
    {
        int[] nums = {0,1,1,1,0,0};
        System.out.println(minOperations(nums));        
    }
}
