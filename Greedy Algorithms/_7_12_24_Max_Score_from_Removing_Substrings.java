class _7_12_24_Max_Score_from_Removing_Substrings
{
    public static int maximumGain(String s, int x, int y) 
    {
        if(x < y)
        {
            int temp = x;
            x = y;
            y = temp;

            s = new StringBuilder(s).reverse().toString();
        }

        int aCount = 0;
        int bCount = 0;
        int totalPoints = 0;

        for(int i=0;i<s.length();i++)
        {
            char currentChar = s.charAt(i);

            if(currentChar == 'a')
            {
                aCount++;
            }
            else if(currentChar == 'b')
            {
                if(aCount > 0)
                {
                    aCount--;
                    totalPoints += x;
                }
                else
                {
                    bCount++;
                }
            }
            else
            {
                totalPoints += Math.min(bCount, aCount) * y;
                aCount = bCount = 0;
            }
        }

        totalPoints += Math.min(bCount, aCount) * y;

        return totalPoints;
    }

    public static void main(String[] args) {
       String s = "cdbcbbaaabab";
       int x = 4, y = 5;
       System.out.print(maximumGain(s, x, y));
    }
}