public class _12_17_24_Construct_String_With_Repeat_Limit 
{
    public static String repeatLimitedString(String s, int repeatLimit) 
    {
        int[] freq = new int[26];

        for(char ch : s.toCharArray())
        {
            freq[ch-'a']++;
        }

        StringBuilder res = new StringBuilder();

        for(int i=25;i>=0;)
        {
            if(freq[i] == 0)
            {
                i--;
                continue;                
            }
                

            if(freq[i] > 0)
            {
                if(freq[i] <= repeatLimit)
                {
                    res.append(String.valueOf((char)('a' + i)).repeat(freq[i]));
                    
                    freq[i] = 0;
                    i--;
                }

                else if (freq[i] > repeatLimit)
                {
                    res.append(String.valueOf((char)('a' + i)).repeat(repeatLimit));
                    
                    freq[i] -= repeatLimit;

                    int j = i-1;
                    while(j>=0 && freq[j] == 0)
                    {
                        j--;
                    }
                    if(j<0)
                        break;
                    
                    res.append(String.valueOf((char)('a' + j)));
                    freq[j]--;

                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "cczazcc";
        int repeatLimit = 3;
        System.out.println(repeatLimitedString(s, repeatLimit));
    }
    
}
