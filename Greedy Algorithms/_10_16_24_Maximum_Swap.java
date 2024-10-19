public class _10_16_24_Maximum_Swap 
{
    public static int maximumSwap(int num) 
    {
        String s = String.valueOf(num);
        int n = s.length();
        char[] digits = s.toCharArray(); 
        int[] maxRight = new int[n];
        maxRight[n - 1] = n - 1;

        for (int i = n - 2; i >= 0; i--) 
        {
            int rightMaxIdx = maxRight[i + 1];
            int rightMaxElement = digits[rightMaxIdx];

            maxRight[i] = digits[i] > rightMaxElement ? i : rightMaxIdx;
        }

        for (int i = 0; i < n; i++) {
            int maxRightIdx = maxRight[i];
            int maxRightElement = digits[maxRightIdx];

            if (digits[i] < maxRightElement) 
            {
                char temp = digits[i];
                digits[i] = digits[maxRightIdx];
                digits[maxRightIdx] = temp;

                return Integer.parseInt(new String(digits));
            }
        }
        return num;
          
    }

    public static void main(String[] args) 
    {
        System.out.println(maximumSwap(9937));   
    }
    
}
