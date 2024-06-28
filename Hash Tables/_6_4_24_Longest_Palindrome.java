public class _6_4_24_Longest_Palindrome {
    public static int longestPalindrome(String s) {
        int freq[] = new int[128];

        for(int i=0;i<s.length();i++)
        {           
            freq[s.charAt(i) - 'A']++;            
        }
        int count = 0;
        
        for(int i=0;i<freq.length;i++)
        {
            count += freq[i]/2 * 2;
            if( freq[i] % 2 == 1 && count % 2 == 0 )
            {
                count++;
            }            
        }           
        return count;
    }

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
    }
}
