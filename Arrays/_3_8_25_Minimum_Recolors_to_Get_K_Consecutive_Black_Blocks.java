public class _3_8_25_Minimum_Recolors_to_Get_K_Consecutive_Black_Blocks 
{
    public static int minimumRecolorsOpt(String blocks, int k) 
    {
        int n = blocks.length();
        int i = 0;
        int j = 0;

        int ops = k;
        int count = 0;
        while(j < n)
        {
            if(blocks.charAt(j) == 'W')
            {
                count++;
            }

            if(j-i+1 == k)
            {
                ops = Math.min(ops,count);

                if(blocks.charAt(i) == 'W')
                {
                    count--;
                }
                i++;
            }
            j++;
        }
        return ops;
    }

    
        public static int minimumRecolors(String blocks, int k) 
        {
            int n = blocks.length();
            int ans = Integer.MAX_VALUE;
            for(int i=0; i+k <= n;i++)
            {
                int count = 0;
                for(int j=i;j<i+k;j++)
                {
                    if(blocks.charAt(j)=='W')
                    {
                        count++;
                    }
                }
                ans = Math.min(ans,count);
            }
            return ans;
        }
    
    public static void main(String[] args) 
    {
        String blocks = "WBBWWBBWBW";
        int k = 7;
        System.out.println(minimumRecolorsOpt(blocks, k));
    }
    
}
