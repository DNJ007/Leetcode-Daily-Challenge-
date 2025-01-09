public class _1_5_25_Shifting_Letters_II 
{
    public static String shiftingLetters(String s, int[][] shifts) 
    {
        //DiffArray Concept
        int[] diffArray = new int[s.length()];

        for(int i=0;i<shifts.length;i++)
        {
            int dir = shifts[i][2];
            int start = shifts[i][0];
            int end = shifts[i][1];
            int x=0;

            if(dir == 0)
            {
                x = -1;
            } 
            else if(dir == 1)
            {
                x = 1;
            }

            diffArray[start] += x;

            if(end+1 < s.length())
                diffArray[end+1] -= x;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<diffArray.length;i++)
        {
            diffArray[i] += diffArray[i-1];
        }

        for(int i=0;i<diffArray.length;i++)
        {
            int shift = diffArray[i] % 26;

            if(shift < 0)
            {
                shift += 26;
            }
            sb.append((char)((((s.charAt(i)-'a') + shift) % 26) + 'a'));
        }
        return sb.toString();
    }

    public static void main(String[] args) 
    {
        String s = "abc";
        int[][] shifts = {{0,1,0},{1,2,1},{0,2,1}};
        System.out.println(shiftingLetters(s, shifts));
        
    }
}
