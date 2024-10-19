public class _10_18_24_Count_Number_of_Maximum_Bitwise_OR_Subsets
{
    public static int countMaxOrSubsets(int[] nums) 
    {
        int maxOrValue = 0;

        for(int num : nums)
        {
            maxOrValue |= num;
        }
        return countSubsets(nums,0,0,maxOrValue);
    }

    private static int countSubsets(int[] nums,int index,int currentOr,int targetOr)
    {
        if(index == nums.length)
        {
            return currentOr == targetOr ? 1 : 0; 
        }

        int countWithout = countSubsets(nums,index+1,currentOr,targetOr);

        int countWith = countSubsets(nums,index+1,currentOr | nums[index],targetOr);

        return countWithout + countWith;
    }
    public static void main(String [] args)
    {
        int[] nums = {3,2,1,5};

        System.out.println(countMaxOrSubsets(nums)); 
    }
}