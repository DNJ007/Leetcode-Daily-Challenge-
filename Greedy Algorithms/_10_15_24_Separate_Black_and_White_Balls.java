public class _10_15_24_Separate_Black_and_White_Balls 
{
    public static long minimumSteps(String s) 
    {      
        long swaps = 0, zeroes = 0;
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)=='1')
            {
                swaps += zeroes;
            }
            else
            {
                zeroes++;
            }
        }
        return swaps;

    }

    public static void main(String[] args) {
        String s = "100";
        System.out.println(minimumSteps(s));
    }
    
}
