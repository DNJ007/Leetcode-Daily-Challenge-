public class _6_2_24_Reverse_a_string
{
    public static void reverseString(char[] s) {
        int n = s.length;
        for(int i=0,j=n-1;i<=j;i++,j--)
        {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }
    public static void main(String [] args)
    {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);

        for(int i=0;i<s.length;i++)
        {
            System.out.print(s[i]+" ");
        }

    }
}