import java.util.Arrays;

public class _7_27_24_Minimum_Cost_To_Convert_String_I 
{
    public static long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) 
    {
        long totalCost = 0;

        long[][] minCost = new long[26][26];

        for(long[] row : minCost)
        {
            Arrays.fill(row,Integer.MAX_VALUE);
        } 

        for(int i=0;i<original.length;++i)
        {
            int startChar = original[i] - 'a';
            int endChar = changed[i] - 'a';

            minCost[startChar][endChar] = Math.min(minCost[startChar][endChar], (long) cost[i]);
        }

        for(int k=0;k<26;++k)
        {
            for(int i=0;i<26;++i)
            {
                for(int j=0;j<26;++j)
                {
                    minCost[i][j] = Math.min(minCost[i][j],minCost[i][k]+minCost[k][j]);
                }
            }
        }

        for(int i=0;i<source.length();++i)
        {
            if(source.charAt(i) == target.charAt(i))
            {
                continue;
            }

            int sourceChar = source.charAt(i) - 'a';
            int targetChar = target.charAt(i) - 'a';

            if(minCost[sourceChar][targetChar] >= Integer.MAX_VALUE)
            {
                return -1;
            }

            totalCost += minCost[sourceChar][targetChar];
        }

        return totalCost;
    } 

    public static void main(String[] args) {
        String source = "abcd", target = "acbe";
        char[] original = {'a','b','c','c','e','d'}, changed = {'b','c','b','e','b','e'};
        int[] cost = {2,5,5,1,2,20};

        System.out.print(minimumCost(source, target, original, changed, cost));
    }
    
}
