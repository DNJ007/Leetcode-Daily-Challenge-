public class _4_5_25_Sum_of_All_Subset_XOR_Totals 
{
    public static int subsetXORSum(int[] nums) 
    {
        return solve(nums,0,0);
    }

    public static int solve(int[] nums,int idx,int currXOR)
    {
        if(idx == nums.length)
            return currXOR;
        
        int withElement = solve(nums,idx+1,currXOR^nums[idx]);

        int withoutElement = solve(nums,idx+1,currXOR);

        return withElement + withoutElement;
    }
    public static void main(String[] args) 
    {
        int[] nums = {3,4,5,6,7,8};
        System.out.println(subsetXORSum(nums));  
    }    
}
