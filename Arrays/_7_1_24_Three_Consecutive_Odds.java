public class _7_1_24_Three_Consecutive_Odds 
{
    public boolean threeConsecutiveOdds(int[] arr) 
    {        
        int count = 0;

        for(int i=0;i<arr.length;i++)
        {
            count = 0;
            int j = i;
            while(j<=i+2 && i+2<arr.length)
            {
                if(arr[j]%2!=0)
                {
                    count++;
                }
                if(count == 3)
                {
                    return true;
                }
                j++;
            }

        }
        return false;
    }
    public static void main(String[] args) {
        
    }
}
