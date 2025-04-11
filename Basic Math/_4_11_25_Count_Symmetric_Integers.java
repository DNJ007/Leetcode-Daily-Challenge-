public class _4_11_25_Count_Symmetric_Integers 
{
    public static int countDigits(int num)
    {
        int count = 0;
        while(num>0)
        {
            count++;
            num = num/10;
        }

        return count;
    }
    public static boolean solve(int num,int dcount)
    {
        int h = dcount/2;
        int sum1 = 0;
        String Num = String.valueOf(num); 
        for(int i=0;i<h;i++)
        {
            int digit = Num.charAt(i)-'0';
            sum1 += digit; 
        }
        int sum2 = 0;
        for(int i=h;i<dcount;i++)
        {
            int digit = Num.charAt(i)-'0';
            sum2 += digit; 
        }

        return sum1 == sum2;
    }
    public static int countSymmetricIntegers(int low, int high) 
    {
        int count = 0;
        for(int i=low;i<=high;i++)
        {
            int digitcount = countDigits(i);
            if(digitcount%2 != 0)
                continue;

            if(solve(i,digitcount))
            {
                count++;
            }
        }   
        return count;     
    }
    public static void main(String[] args) 
    {
        int low = 1, high = 100;
        System.out.println(countSymmetricIntegers(low, high));

        
    }    
}
