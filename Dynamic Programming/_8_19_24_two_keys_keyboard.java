public class _8_19_24_two_keys_keyboard
{
    public static int minSteps(int n) 
    {
        if (n == 1) 
            return 0;
        // first step is always a Copy All operation
        return 1 + minStepsHelper(1, 1,n);
    }

    private static int minStepsHelper(int currLen, int pasteLen,int n) 
    {
        // base case: reached n A's, don't need more operations
        if (currLen == n) 
            return 0;
        // base case: exceeded n `A`s, not a valid sequence, so
        // return max value
        if (currLen > n) 
            return 1000;

        // copy all + paste
        int opt1 = 2 + minStepsHelper(currLen * 2, currLen, n);
        // paste
        int opt2 = 1 + minStepsHelper(currLen + pasteLen, pasteLen, n);

        return Math.min(opt1, opt2);
    }
    public static void main(String [] args)
    {
        System.out.println(minSteps(3)); 
    }
}