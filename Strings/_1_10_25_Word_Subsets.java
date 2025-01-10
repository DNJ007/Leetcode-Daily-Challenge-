import java.util.*;
public class _1_10_25_Word_Subsets
{
    private static boolean isUniversal(int[] wordFreq,int[] maxFreq)
    {
        for(int i=0;i<26;i++)
        {
            if(wordFreq[i] < maxFreq[i])
            {
                return false;
            }
        }
        return true;
    }
    
    public static List<String> wordSubsets(String[] words1, String[] words2) 
    {
       int[] maxFreq = new int[26];

       for(String word : words2)
       {
            int[] freq = new int[26];
            for(char c : word.toCharArray())
            {
                freq[c-'a']++;
            }
            for(int i=0;i<26;i++)
            {
                maxFreq[i] = Math.max(maxFreq[i], freq[i]);
            }
       }

       List<String> result = new ArrayList<>();
       for(String word : words1)
       {
            int[] freq = new int[26];

            for(char c : word.toCharArray())
            {
                freq[c-'a']++;
            }

            if(isUniversal(freq, maxFreq))
            {
                result.add(word);
            }
       }
       return result;
    }
    public static void main(String [] args)
    {
        String[] words1 = {"amazon","apple","facebook","google","leetcode"};
        String[] words2 = {"e","o"};
        System.out.println(wordSubsets(words1, words2)); 
    }
}