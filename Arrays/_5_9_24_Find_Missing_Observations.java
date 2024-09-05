public class _5_9_24_Find_Missing_Observations 
{
    public static int[] missingRolls(int[] rolls, int mean, int n) 
    {
        int m = rolls.length;
        int sumOfM = 0;

        for(int i=0;i<rolls.length;i++)
        {
            sumOfM += rolls[i];
        }

        int[] nRolls = new int[n];
        
        int sumOfN = (n+m)*mean - sumOfM;
        
        if(sumOfN > n*6 || sumOfN < n)
        {
            return new int[]{};
        }

        if(sumOfN % n == 0)
        {
            for(int i=0;i<nRolls.length;i++)
            {
                nRolls[i] = sumOfN/n;
            }
        }
        else
        {
            for(int i=0;i<nRolls.length;i++)
            {
                nRolls[i] = sumOfN/n;
            }

            int sumNRolls = nRolls.length * (sumOfN/n);

            int diff = sumOfN - sumNRolls;

            for(int i=0;i<nRolls.length;i++)
            {
                if(diff == 0)
                {
                    break;
                }
                if(nRolls[i]+diff <= 6)
                {
                    nRolls[i] += diff;
                    diff = 0;
                }
                else
                {
                   int rem = 6 - nRolls[i];
                   nRolls[i] = 6;
                   diff = diff-rem; 
                }
            }
        }
        return nRolls;     
    }
    
    public static void main(String[] args) 
    {
        int[] rolls = {1,5,6};
        int mean = 3, n = 4;
        
        int[] nrolls = new int[n];
        nrolls = missingRolls(rolls, mean, n);

        for(int i=0;i<nrolls.length;i++)
        {
            System.out.print(nrolls[i]+" ");
        }
    }
}
