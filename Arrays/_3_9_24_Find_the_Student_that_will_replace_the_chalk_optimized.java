public class _3_9_24_Find_the_Student_that_will_replace_the_chalk_optimized 
{
    public static int chalkReplacer(int[] chalk, int k) 
    {
        // Find the sum of all elements.
        long sum = 0;
        for (int i = 0; i < chalk.length; i++) 
        {
            sum += chalk[i];
            if (sum > k) {
                break;
            }
        }
        // Find modulo of k with sum.
        k = k % (int) sum;
        for (int i = 0; i < chalk.length; i++) 
        {
            if (k < chalk[i]) {
                return i;
            }
            k = k - chalk[i];
        }
        return 0;
    }
    public static void main(String [] args)
    {
        int[] chalk = {5,1,5};
        System.out.println(chalkReplacer(chalk, 22)); 
    }
    
    
}
