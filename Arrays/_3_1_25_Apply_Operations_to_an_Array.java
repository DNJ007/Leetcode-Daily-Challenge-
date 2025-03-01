public class _3_1_25_Apply_Operations_to_an_Array
{
    public static int[] applyOperations(int[] nums) 
    {
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length-1;i++)
        {
            if(nums[i] == nums[i+1])
            {
                nums[i] = nums[i]*2;
                nums[i+1] = 0;
            }            
        }
        int k = 0;
        for(int i=0;i<res.length;i++)
        {
            if(nums[i] == 0)
                continue;
            
            res[k++] = nums[i];

        }
        return res;
        
    }
    public static void main(String [] args)
    {
        int[] nums = {1,2,2,1,1,0};
        System.out.println(applyOperations(nums)); 
    }
}