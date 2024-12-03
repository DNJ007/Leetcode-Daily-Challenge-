public class _12_3_24_Adding_spaces_to_String
{
    public static String addSpaces(String s, int[] spaces) 
    {
        StringBuilder sb = new StringBuilder("");
        int j = 0;
        for(int i=0;i<s.length();i++)
        {
            if(j<spaces.length && i == spaces[j])
            {
                sb.append(" ");
                j++;
            }
            
            sb.append(s.charAt(i));
            
        }
        return sb.toString();
    }
    public static void main(String [] args)
    {
        int [] spaces = {8,13,15};
        System.out.println(addSpaces("LeetcodeHelpsMeLearn", spaces)); 
    }
}