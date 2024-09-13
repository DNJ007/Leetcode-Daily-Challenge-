public class _9_13_24_XOR_Queries_of_a_Subarray
{
    public static int[] xorQueries(int[] arr, int[][] queries) 
    {
        //T.C : O(N*Q)
        int k = 0;
        int[] xorArr = new int[queries.length];

        for(int i=0;i<queries.length;i++)
        {
            int start = queries[i][0];
            int end = queries[i][1];

            int x = 0;
            for(int j=start;j<=end;j++)
            {
                x ^= arr[j];
            }
            xorArr[k++] = x; 
        }

        return xorArr;
    }

    public static int[] xorQueriesPrefixSum(int[] arr, int[][] queries) 
    {
        //T.C : O(n+q)
        int[] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];

        for(int i=1;i<arr.length;i++)
        {
            prefixSum[i] = prefixSum[i-1] ^ arr[i];
        }

        int[] res = new int[queries.length];
        for(int k=0;k<queries.length;k++)
        {
            int i = queries[k][0];
            int j = queries[k][1];
            if(i == 0)
            {
                res[k] = prefixSum[j];
            }
            else
            {
                res[k] = prefixSum[j] ^ prefixSum[i-1];
            }
        }
        return res;
    }

    public static void main(String [] args)
    {
        int [] arr = {4,8,2,10};
        int[][] queries = {{2,3},{1,3},{0,0},{0,3}};
        arr = xorQueriesPrefixSum(arr, queries);
        
        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}