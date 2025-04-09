public class _4_8_25_Minimum_Number_of_Operations_to_Make_Elements_in_Array_Distinct 
{
    public static int minimumOperations(int[] nums) 
    {
        boolean[] vis = new boolean[101];
        int ans = 0;
        
        int idx = -1;
        for(int i=nums.length-1;i>=0;i--)
        {
            if(vis[nums[i]])
            {
                idx = i;
                break;
            }
            vis[nums[i]] = true;
        }
        int l = idx + 1;
        if((l%3) != 0)
        {
            ans = l/3 + 1;
        }
        else
        {
            ans = l/3;
        }
        
        return ans;
    }

    public static void main(String[] args) 
    {
        int[] nums = {1,2,3,4,2,3,3,5,7};
        System.out.println(minimumOperations(nums));
    }
}
