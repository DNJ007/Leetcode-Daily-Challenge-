import java.util.*;
public class _11_4_24_String_Compression_III 
{
    static class element{
        char ch;
        int freq;

        element(char ch,int freq)
        {
            this.ch = ch;
            this.freq = freq;
        }
    }
    public static String compressedString(String s) 
    {
        if(s.length()==1)
        {
            return "1"+s.charAt(0);
        }
        int count = 1;
        String comp = "";

        ArrayList<Integer> Al = new ArrayList<>();
        for(int i=0;i<s.length()-1;i++)
        {
            char ch = s.charAt(i);
            char nextch = s.charAt(i+1);

            if(ch == nextch)
            {
                if(count < 9)
                {
                    count++;
                }
                else
                {
                    Al.add(count);
                    count = 1;
                }
            }
            else
            {
                Al.add(count);
                count = 1;
            }

            if(i == s.length()-2)
            {
                Al.add(count);
            }
        }

        ArrayList<Character> Al2 = new ArrayList<>();
        Queue<element> q = new LinkedList<>();
        char prev = s.charAt(0);
        Al2.add(prev);
        int counts = 1;
        for(char ch : s.substring(1,s.length()).toCharArray())
        {
            if(prev!=ch)
            {
                Al2.add(ch);
                q.add(new element(prev, counts));
                counts=1;
            }
            else{
                counts++;
            }
            prev = ch;
        }
        q.add(new element(prev,counts));

        System.out.println(Al);
        System.out.println(Al2);
        /*while(!q.isEmpty())
        {
            element e = q.poll();
            System.out.println(e.ch+" "+e.freq);
        }*/



        int i=0;
        while(!q.isEmpty())
        {
            element e = q.poll();
            char ch = e.ch;
            if(e.freq > 9)
            {   
                int freq = e.freq;
                int rem = freq % 9;
                int div = freq / 9;

                while(div>0)
                {
                    comp += String.valueOf(9) + ch;
                    div--;
                    i++;
                }
                if(rem > 0)
                {
                    comp += String.valueOf(rem) + ch;
                    i++;
                }               
                
            }
            else
            {
                comp += String.valueOf(Al.get(i++)) + ch;
            }
                
        }

        return comp;
        
    }
    public static void main(String[] args) {
        System.out.println(compressedString("mmmmmmmmmmmmmmmmmmzzzzzzzzzzzzzzzzzzyyyyyyyyyyyfvs"));
    }
}
