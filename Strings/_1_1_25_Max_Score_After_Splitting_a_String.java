public class _1_1_25_Max_Score_After_Splitting_a_String 
{
    public static int maxScore(String s) 
    {
        int[] suffixSumOne = new int[s.length()];
        int[] prefixSumZero = new int[s.length()];

        suffixSumOne[suffixSumOne.length-1] = s.charAt(s.length()-1) == '1' ? 1 : 0;
        prefixSumZero[0] = s.charAt(0) == '0' ? 1 : 0;

        for(int i=1;i<prefixSumZero.length;i++)
        {
            if(s.charAt(i) == '0')
            {
                prefixSumZero[i] = prefixSumZero[i-1] + 1;
            }
            else
            {
                prefixSumZero[i] = prefixSumZero[i-1];
            }
        }
        
        for(int i=suffixSumOne.length-2;i>=0;i--)
        {
            if(s.charAt(i) == '1')
            {
                suffixSumOne[i] = suffixSumOne[i+1] + 1;
            }
            else
            {
                suffixSumOne[i] = suffixSumOne[i+1];
            }
        }
        
        int maxScore = 0;
        for(int i=0;i<s.length()-1;i++)
        {
            maxScore = Math.max(maxScore,prefixSumZero[i]+suffixSumOne[i+1]);
        }
        return maxScore;
    }

    public static void main(String[] args) 
    {
        String s = "011101";
        System.out.println(maxScore(s));
        
    }

    
}
