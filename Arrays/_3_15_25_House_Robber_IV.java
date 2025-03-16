public class _3_15_25_House_Robber_IV
{
    public static boolean isPossible(int[] nums,int mid,int k)
    {
        int house = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] <= mid)
            {
                house++;
                i++; // skipping adjacent houses
            }
        }
        return house >= k; // we manage to rob atleast k houses
    }

    public static int minCapability(int[] nums, int k) {
        int r = 0;
        int l = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            l = Math.min(l,nums[i]);
            r = Math.max(r,nums[i]);
        }

        int res = r;
        //T.C : O(N * log(r))
        while(l <= r)
        {
            int mid = l + (r-l)/2;

            if(isPossible(nums,mid,k))
            {
                res = mid;
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return res;
    }
    public static void main(String [] args)
    {
        int[]nums = {2,7,9,3,1};
        int k = 2;
        System.out.println(minCapability(nums,k)); 
    }
}