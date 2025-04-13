public class _4_13_25_Count_Good_Numbers
{
    static int MOD = 1000000007;
    private static long pow(int a,long b)
    {
        if(b == 0)
        {
            return 1;
        }

        long half = pow(a,b/2);
        long result = (half * half) % MOD;

        if(b%2 == 1)
        {
            result = (result*a) % MOD; 
        }

        return (int)result;
    }
    public static int countGoodNumbers(long n) 
    {       
        long count = 1;

        count = pow(5,(n+1)/2)* pow(4,n/2);

        return (int)(count%MOD);
    }
    public static void main(String [] args)
    {
        System.out.println(countGoodNumbers(50)); 
    }
}