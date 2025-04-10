public class _4_10_25_Count_the_Number_of_Powerful_Integers
{
    private static long solve(String str,String inputSuffix,int limit)
    {
        if(str.length() < inputSuffix.length())
        {
            return 0;
        }

        long count = 0;
        int l = str.length() - inputSuffix.length();
        String trailString = str.substring(l);

        for(int i=0;i<l;i++)
        {
            int digit = str.charAt(i) - '0';

            if(digit <= limit)
            {
                count += digit * Math.pow(limit+1,l-i-1);
            }
            else
            {
                count += Math.pow(limit+1,l-i);
                return count;
            }
        }
        long suffixVal = Long.parseLong(inputSuffix);
        long trailVal = Long.parseLong(trailString);

        if(trailVal >= suffixVal)
        {
            count++;
        }
        return count;
    }
    public static long numberOfPowerfulInt(long start, long finish, int limit, String s) 
    {
        String finishStr = String.valueOf(finish);
        String startStr = String.valueOf(start-1);

        return solve(finishStr,s,limit) - solve(startStr,s,limit);
    }
    public static void main(String [] args)
    {
        int start = 1, finish = 6000, limit = 4;
        String s = "124";
        System.out.println(numberOfPowerfulInt(start, finish, limit, s)); 
    }
}