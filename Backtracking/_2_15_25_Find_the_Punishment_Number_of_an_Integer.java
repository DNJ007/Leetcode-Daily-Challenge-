public class _2_15_25_Find_the_Punishment_Number_of_an_Integer
{
    public static boolean canPartition(int sq,int num)
    {
        if(num < 0 || sq < num)
        {
            return false;
        }

        if(num == sq)
        {
            return true;
        }

        return (canPartition(sq/10,num-(sq%10)) || 
                canPartition(sq/100,num-(sq%100)) ||
                canPartition(sq/1000,num-(sq%1000)));
    }
    public static int punishmentNumber(int n) 
    {
        int ans = 0;
        for(int i=1;i<=n;i++)
        {
            int sq = i*i;           
           
            if(canPartition(sq,i))
            {
                ans += sq;
            }
        }
        return ans;
        
    }
    public static void main(String [] args)
    {
        System.out.println(punishmentNumber(37)); 
    }
}