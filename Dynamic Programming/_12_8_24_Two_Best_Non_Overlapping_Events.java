import java.util.*;
class _12_8_24_Two_Best_Non_Overlapping_Events
{
    static int n;
    public static int binarySearch(int[][] events, int end)
    {
        int l = 0;
        int r = n-1;
        int res = n;

        while(l<=r)
        {
            int mid = l + (r-l)/2;

            if(events[mid][0] > end)
            {
                res = mid;
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }
        return res;
    }
    public static int solve(int[][] events,int i,int count,int[][] dp)
    {
        if(count == 2 || i>=n)
        {
            return 0;
        }

        if(dp[i][count] != -1)
        {
            return dp[i][count];
        }
        
        int nextValidEventIndex = binarySearch(events,events[i][1]);
        int take = events[i][2] + solve(events, nextValidEventIndex, count+1, dp);

        int not_take = solve(events, i+1, count, dp);

        return dp[i][count] = Math.max(take, not_take);

    }
    public static int maxTwoEvents(int[][] events) 
    {
        n = events.length;
        int dp[][] = new int[n][3];
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        int count = 0;
        return solve(events, 0, count, dp);
    }

    public static void main(String[] args) 
    {
       int[][] events = {{1,3,2},{4,5,2},{2,4,3}};
       System.out.println(maxTwoEvents(events));
    }
}