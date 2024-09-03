public class _3_9_24_Find_the_Student_that_will_replace_the_chalk_intuitive
{
    public static int chalkReplacer(int[] chalk, int k) 
    {
        while(k > 0)
        {
            for(int i=0;i<chalk.length;i++)
            {
                if(k == 0 || k < chalk[i])
                {
                    return i;
                }
                k = k - chalk[i];
            }
        }
        return 0;             
    }
    public static void main(String [] args)
    {
        int[] chalk = {5,1,5};
        System.out.println(chalkReplacer(chalk, 22)); 
    }
}