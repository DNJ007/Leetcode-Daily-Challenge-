public class _10_30_24_Minimum_Number_of_Removals_to_Make_Mountain_Array 
{
    public static int minimumMountainRemovals(int[] nums) 
    {
        int n = nums.length;

        if(n<3) return 0;

        int prefix[] = new int[nums.length];
        int suffix[] = new int[nums.length];

        for(int i=0;i<n;i++)
        {
            prefix[i] = 1;
            for(int j=0;j<i;j++)
            {
                if(nums[j] < nums[i])
                {
                    prefix[i] = Math.max(prefix[i], prefix[j] + 1);
                }
            }
        }

        for(int i=n-1;i>=0;i--)
        {
            suffix[i] = 1;
            for(int j = n-1;j>i;j--)
            {
                if(nums[j] < nums[i])
                {
                    suffix[i] = Math.max(suffix[i],suffix[j]+1);
                }
            }
        }

        int minRemovals = n;

        for(int i=0;i<n;i++)
        {
            if(prefix[i]>1 && suffix[i] > 1)
                minRemovals = Math.min(minRemovals, n-prefix[i]-suffix[i]+1);
        }

        return minRemovals;
    }

    public static void main(String[] args) 
    {
        int nums[]= {2,1,1,5,6,2,3,1};
        System.out.println(minimumMountainRemovals(nums));
        
    }
    
}
