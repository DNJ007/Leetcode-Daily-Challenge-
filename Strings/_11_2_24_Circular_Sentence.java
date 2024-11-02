public class _11_2_24_Circular_Sentence
{
    public static boolean isCircularSentence(String s) 
    {
        String str[] = s.split(" ");
        int count = 0;
        for(int i=0;i<str.length-1;i++)
        {
            if(str[i].charAt(str[i].length()-1) == str[i+1].charAt(0))
            {
                count++;
            }
            else
            {
                return false;
            }
        }

        if(str[str.length-1].charAt(str[str.length-1].length()-1) == str[0].charAt(0))
        {
            count++;
        }
        else
        {
            return false;
        }

        if(count == str.length)
        {
            return true;
        }

        return false;
        
    }
    public static void main(String [] args)
    {
        String sentence = "leetcode exercises sound delightful";
        System.out.println(isCircularSentence(sentence)); 
    }
}