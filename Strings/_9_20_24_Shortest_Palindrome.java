public class _9_20_24_Shortest_Palindrome 
{
    public static String shortestPalindrome(String s) 
    {
        String revstr = new StringBuilder(s).reverse().toString();
        for(int i=0;i<s.length();i++)
        {
            if(s.substring(0, s.length() - i).equals(revstr.substring(i)))
            {
                return new StringBuilder(revstr.substring(0, i)).append(s).toString();
            }
        }
        return "";        
    }

    public static String shortestPalindrome2(String s) 
    {
        int length = s.length();

        if(length == 0)
            return s;

        int left = 0;
        for(int right = length - 1;right >= 0;right--)
        {
            if(s.charAt(right) == s.charAt(left))
            {
                left++;
            }
        }

        if(left == length)
        {
            return s;
        }

        String nonPalindromeSuffix = s.substring(left);
        StringBuilder reverseSuffix = new StringBuilder(nonPalindromeSuffix).reverse();

        return reverseSuffix.append(shortestPalindrome(s.substring(0,left))).append(nonPalindromeSuffix).toString();
        
    }

    public static void main(String[] args) {
        
        System.out.println(shortestPalindrome("aacecaaa"));
    }
    
}
