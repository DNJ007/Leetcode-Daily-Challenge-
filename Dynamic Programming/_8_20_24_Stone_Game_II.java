import java.util.Arrays;

public class _8_20_24_Stone_Game_II
{
    public static int stoneGameII(int[] piles) 
    {        
        int[] suffixSum = Arrays.copyOf(piles, piles.length);

        for (int i = suffixSum.length - 2; i >= 0; i--) 
        {
            suffixSum[i] += suffixSum[i + 1];
        }
        return maxStones(suffixSum, 1, 0, new int[piles.length][piles.length]);
    }

    private static int maxStones(int[] suffixSum, int maxTillNow, int currIndex,int[][] memo) 
    {
        // If currIndex + 2*maxTillNow lies outside the array, pick all remaining stones.
        if (currIndex + 2 * maxTillNow >= suffixSum.length) 
        {
            return suffixSum[currIndex];
        }
        if (memo[currIndex][maxTillNow] > 0) 
            return memo[currIndex][maxTillNow];

        int res = Integer.MAX_VALUE;
        // Find the minimum value res for the next move possible.
        for (int i = 1; i <= 2 * maxTillNow; i++) 
        {
            res = Math.min( res,maxStones(suffixSum, Math.max(i, maxTillNow), currIndex + i, memo ));
        }
        // Memoize the difference of suffixSum[p] and res. This denotes the maximum
        // stones that can be picked.
        memo[currIndex][maxTillNow] = suffixSum[currIndex] - res;
        
        return memo[currIndex][maxTillNow];
    }
    public static void main(String [] args)
    {
        int[] piles = {2,7,9,4,4};
        System.out.println(stoneGameII(piles)); 
    }
}