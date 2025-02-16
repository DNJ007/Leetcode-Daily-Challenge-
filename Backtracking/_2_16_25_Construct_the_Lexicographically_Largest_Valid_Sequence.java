import java.util.Arrays;

public class _2_16_25_Construct_the_Lexicographically_Largest_Valid_Sequence
{
    private static boolean solve(int i,int n,int[] res,boolean[] used)
    {
        if(i >= res.length)
        {
            return true;
        }

        if(res[i] != -1)
        {
            return solve(i+1,n,res,used);
        }

        for(int num=n;num>=1;num--)
        {
            if(used[num])
            {
                continue;
            }

            used[num] = true;
            res[i] = num;

            if(num == 1)
            {
                if(solve(i+1,n,res,used) == true)
                {
                    return true;
                }
            }
            else
            {
                int j = res[i] + i;

                if(j < res.length && res[j] == -1)
                {
                    res[j] = num;
                    if(solve(i+1,n,res,used) == true)
                    {
                        return true;
                    }
                    res[j] = -1;
                }
            }

            used[num] = false;
            res[i] = -1;

        }
        return false;
    }
    public static int[] constructDistancedSequence(int n) 
    {
        int[] res = new int[2*n-1];
        Arrays.fill(res,-1);
        boolean used[] = new boolean[n+1];

        solve(0,n,res,used);

        return res;        
    }
    public static void main(String [] args)
    {
        int n = 3;
        int[] ans = constructDistancedSequence(n);
        for(int i=0;i<ans.length;i++)
        {
            System.out.print(ans[i]+" ");
        } 
    }
}