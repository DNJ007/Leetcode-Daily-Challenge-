public class _1_2_25_Count_Vowel_Strings_in_Ranges 
{
    public static int[] vowelStrings(String[] words, int[][] queries) 
    {
        int[] isVowel = new int[words.length];
        int[] res = new int[queries.length];

        int count = 0;
        for(int i=0;i<words.length;i++)
        {
            if((words[i].charAt(0) == 'a' || 
            words[i].charAt(0) == 'e' ||
            words[i].charAt(0) == 'i' ||
            words[i].charAt(0) == 'o' ||
            words[i].charAt(0) == 'u') 
            && 
            (words[i].charAt(words[i].length()-1) == 'a' ||
             words[i].charAt(words[i].length()-1) == 'e' ||
             words[i].charAt(words[i].length()-1) == 'i' ||
             words[i].charAt(words[i].length()-1) == 'o' ||
             words[i].charAt(words[i].length()-1) == 'u' 
            ))
            {
                count += 1;
                isVowel[i] = count; 
            }
            else
            {
                isVowel[i] = count;
            }
        }

        for(int i=0;i<queries.length;i++)
        {
            int l = queries[i][0];
            int r = queries[i][1];

            if(l>0)
            {
                res[i] = isVowel[r] - isVowel[l-1];
            }
            else
            {
                res[i] = isVowel[r];
            }
        }

        return res;
        
    }

    public static void main(String[] args) 
    {
        String [] words = {"aba","bcb","ece","aa","e"};
        int[][] queries = {{0,2},{1,4},{1,1}};

        System.out.println(vowelStrings(words, queries));
        
    }
    
}
