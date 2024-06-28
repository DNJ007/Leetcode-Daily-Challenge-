public class _6_1_24_Score_of_a_String
 {
    public static int scoreOfString(String s) 
    {
        int score = 0;
        for(int i=0;i<s.length()-1;i++)
        {
            score += (int) Math.abs(s.charAt(i) - s.charAt(i+1));
        }
        return score;
    }
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(scoreOfString(s));
    }
}
