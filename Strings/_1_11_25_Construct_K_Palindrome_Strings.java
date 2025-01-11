public class _1_11_25_Construct_K_Palindrome_Strings 
{
    public static boolean canConstruct(String s, int k) 
    {
        if(k == s.length())
            return true;
        
        if(k > s.length())
            return false;

        int[] freq = new int[26];

        for(int i=0;i<s.length();i++)
        {
            freq[s.charAt(i)-'a']++;
        }

        int oddCharFreq = 0;
        for(int i=0;i<26;i++)
        {
            if(freq[i]%2!=0)
            {
                oddCharFreq++;
            }
        }

        if(oddCharFreq > k)
        {
            return false;
        }
        return true;
    }

    public static void main(String[] args) 
    {
        String s = "annabelle";
        int k = 2;
        System.out.println(canConstruct(s, k));
        
    }
    
}
