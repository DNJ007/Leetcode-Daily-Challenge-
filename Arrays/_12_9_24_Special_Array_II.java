public class _12_9_24_Special_Array_II
{
    public static boolean[] isArraySpecialbruteForce(int[] nums, int[][] queries) 
    {
        boolean[] res = new boolean[queries.length];
        int k = 0;
        boolean isEven = false;
        for(int i=0;i<queries.length;i++)
        {
            int start = queries[i][0];
            int end = queries[i][1];
            if(nums[start]%2 == 0)
            {
                isEven = true;
            }
            else
                isEven = false;

            for(int j=start+1;j<=end && j<nums.length;j++)
            {
                if(isEven)
                {
                    if(nums[j]%2 == 0)
                    {
                        res[k++] = false;
                        break;
                    }
                    else
                    {
                        isEven = false;
                    }
                }
                else
                {
                    if(nums[j]%2 != 0)
                    {
                        res[k++] = false;
                        break;
                    }
                    else
                    {
                        isEven = true;
                    }
                }                
            }
            if(k == i)
            {
                res[k++] = true;
            }
        }
        return res;
    }

    public static boolean[] isArraySpecialOptimized(int[] nums, int[][] queries) 
    {
        boolean[] res = new boolean[queries.length];
        int[] prefix = new int[nums.length];
        prefix[0] = 0;
        for(int i=1;i<nums.length;i++)
        {
            if((nums[i-1] + nums[i]) % 2 == 0)
            {
                prefix[i] = prefix[i-1] + 1;
            }
            else
                prefix[i] = prefix[i-1];
        }
        

        for(int i=0;i<queries.length;i++)
        {
            int start = queries[i][0];
            int end = queries[i][1];

            res[i] = prefix[end] - prefix[start] == 0;
        }
        return res;
    }
    public static void main(String [] args)
    {
        int[] nums = {3,4,1,2,6};
        int[][] queries = {{0,4},{1,2}};
        boolean[] res = isArraySpecialbruteForce(nums, queries); 

        for(int i=0;i<res.length;i++)
        {
            System.out.print(res[i]+" ");
        }
        System.out.println();
        boolean[] res2 = isArraySpecialOptimized(nums, queries); 
        
        for(int i=0;i<res.length;i++)
        {
            System.out.print(res2[i]+" ");
        }
    }
}