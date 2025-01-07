import java.util.ArrayList;
import java.util.List;

public class _1_7_25_String_Matching_in_an_Array 
{
    public static List<String> stringMatching(String[] words) 
    {
        List<String> Al = new ArrayList<>();
        for(int i=0;i<words.length;i++)
        {
            for(int j=0;j<words.length;j++)
            {
                if(i!=j && words[j].contains(words[i]) && !Al.contains(words[i]))
                {
                    Al.add(words[i]);
                }
            }
        }
        return Al;
    }

    public static void main(String[] args) {
        String[]words = {"mass","as","hero","superhero"};
        System.out.println(stringMatching(words));
    }
    
}
