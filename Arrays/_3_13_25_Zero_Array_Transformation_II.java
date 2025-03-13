public class _3_13_25_Zero_Array_Transformation_II 
{
    public static boolean check(int[] nums,int[][] queries,int mid)
    {
        int[] diff = new int[nums.length];
        for(int i=0;i<=mid;i++)
        {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            diff[l] += val;
            if(r+1 < nums.length)
                diff[r+1] -= val;
        }

        int sum = 0;
        for(int i=0;i<nums.length;i++)
        {
            sum += diff[i];

            diff[i] = sum;

            if(nums[i] - diff[i] > 0)
            {
                return false;
            }
        }
        return true;
    }
    public static int minZeroArray(int[] nums, int[][] queries) 
    {
        int count0 = 0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i] == 0)
            {
                count0++;
            }                
        }
        if(count0 == nums.length) return 0;
        
        int l = 0;
        int r = queries.length-1;
        int res = -1;
        while(l<=r)
        {
            int mid = l + (r - l)/2;

            if(check(nums,queries,mid))
            {
                res = mid+1;
                r = mid-1;
            }
            else
            {
                l = mid+1;
            }            
        }
        return res;
        
    }
    public static void main(String[] args) 
    {
        int[] nums = {2,0,2};
        int[][] queries = {{0,2,1},{0,2,1},{1,1,3}};
        System.out.println(minZeroArray(nums, queries));
    }
    
}
