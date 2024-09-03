import java.util.HashMap;

public class _9_4_24_Sum_of_Digits_of_String_After_Convert
{
    public static int getLucky(String s, int k) 
    {
        HashMap<Character,String> hm = new HashMap<>();

        char ch = 'a';
        for(int i=1;i<=26;i++)
        {
            hm.put(ch,String.valueOf(i));
            ch++;
        }

        StringBuilder s1= new StringBuilder("");
        for(int i=0;i<s.length();i++)
        {
            s1.append(hm.get(s.charAt(i)));
        }

        String s2 = s1.toString();
        int num=0;
        while(k>0)
        {
            num = 0;
            for(int i=0;i<s2.length();i++)
            {
                num +=s2.charAt(i)-'0';
            }

            s2 = String.valueOf(num);
            k--;
        }

        return num;

    }
    public static void main(String [] args)
    {
        System.out.println(getLucky("iiii", 1)); 
        System.out.println(getLucky("leetcode", 2)); 
        System.out.println(getLucky("zbax", 2)); 
    }
}