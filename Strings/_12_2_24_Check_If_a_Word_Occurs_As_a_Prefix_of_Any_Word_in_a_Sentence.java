public class _12_2_24_Check_If_a_Word_Occurs_As_a_Prefix_of_Any_Word_in_a_Sentence 
{
    public static int isPrefixOfWord(String s, String searchWord) 
    {
        int n = searchWord.length();
        String[] str = s.split(" ");
        int j = n;
        for(int i=0;i<str.length;i++)
        {
            if(j<=str[i].length())
            {
                if(str[i].substring(0,j).equals(searchWord))
                {
                    return i + 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) 
    {
        String sentence = "this problem is an easy problem", searchWord = "pro";
        System.out.println(isPrefixOfWord(sentence, searchWord));
        
    }
        
    
}
