public class _2_19_25_Kth_Lexicographical_String_of_All_Happy_Strings_of_Length_n 
{
    private static int count = 0; 
    private static String res = ""; 
    public static String getHappyString(int n, int k) 
    {
        StringBuilder curr = new StringBuilder("");
        solve(curr,k,n);
        return res;
    }


    public static void solve(StringBuilder curr,int k,int n)
    {
        if(curr.length() == n)
        { 
            count++;
            if(k == count)
            {
                res = curr.toString();
            }
            return;
        }

        for(char ch = 'a';ch<='c';ch++)
        {
            if(!curr.isEmpty() && curr.charAt(curr.length()-1) == ch)
                continue;
            curr.append(ch);

            solve(curr,k,n);

            curr.deleteCharAt(curr.length()-1);
        }
        if (!res.isEmpty()) return;
    }

    public static void main(String[] args) {
        int n = 4, k = 10;
        System.out.println(getHappyString(n, k));
    }
    
}
