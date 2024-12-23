class _12_22_24_Find_Building_Where_Alice_and_Bob_Can_Meet
{
    public static int[] leftmostBuildingQueries(int[] heights, int[][] queries) 
    {
        int[] ans = new int[queries.length];
        for(int i=0;i<queries.length;i++)
        {
            int alice = queries[i][0];
            int bob = queries[i][1];

            if(alice == bob)
            {
                ans[i] = alice;
                continue;
            }
            
            if(heights[alice] < heights[bob] && alice < bob)
            {
                ans[i] = bob;
                continue;
            }

            if(heights[alice] > heights[bob] && alice > bob)
            {
                ans[i] = alice;
                continue;
            }
            int j = Math.max(bob,alice) ;

                while(j<heights.length)
                {
                    if(heights[alice] < heights[j] && heights[bob] < heights[j])
                    {
                        break;
                    } 
                    j++;
                }
            
            

            if(j<heights.length)
            {
                ans[i] = j;
            }
            else
                ans[i] = -1;
           
        }

        return ans;
    }

    public static void main(String[] args) 
    {
        int[] heights = {6,4,8,5,2,7};
        int[][] queries = {{0,1},{0,3},{2,4},{3,4},{2,2}};

        int[] arr = leftmostBuildingQueries(heights, queries);

        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }

    }
}