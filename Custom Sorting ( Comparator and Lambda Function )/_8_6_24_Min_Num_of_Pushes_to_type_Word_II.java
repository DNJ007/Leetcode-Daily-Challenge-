import java.util.*;

public class _8_6_24_Min_Num_of_Pushes_to_type_Word_II 
{
    static class Object implements Comparable<Object>
    {
        char ch;
        int freq;

        public Object(char ch,int freq)
        {
            this.ch = ch;
            this.freq = freq;
        }

        @Override
        public int compareTo(Object o2)
        {
            return o2.freq - this.freq;
        }
    }
    public static int minimumPushes(String word) 
    {
        //T.C : O(n + k log k)
        //S.C : O(n)
        HashMap<Character,Integer> hm1 = new HashMap<>();

        for(int i=0;i<word.length();i++)
        {
            char ch = word.charAt(i);
            hm1.put(ch,hm1.getOrDefault(ch,0)+1);
        }

        ArrayList<Object> al = new ArrayList<Object>();

        for(char ch : hm1.keySet())
        {
            al.add(new Object(ch,hm1.get(ch)));
        }

        Collections.sort(al);
        /*
        System.out.println(al.size());
        System.out.println(hm1);
        System.out.println(hm1.size());
        for(int i=0;i<al.size();i++)
        {
            System.out.print(al.get(i).ch +" "+al.get(i).freq);
            System.out.println();
        }*/     

        HashMap<Character,String> hm2 = new HashMap<Character,String>();
        int j = 0;
        for(int i=2;i<=9 && j<al.size();i++,j++)
        {
            String s = "";
            s = Integer.toString(i);
            hm2.put(al.get(j).ch,s);
        }        

        if(al.size() > 7)
        {
            for(int i=2;i<=9 && j<al.size();i++,j++)
            {   
                String s = "";
                s = Integer.toString(i*10+i);
                hm2.put(al.get(j).ch,s);
            }
        }
        if(al.size() > 14)
        {
            for(int i=2;i<=9 && j<al.size();i++,j++)
            {   
                String s = "";
                s = Integer.toString(i*100+i*10+i);
                hm2.put(al.get(j).ch,s);
            }
        }
        if(al.size() > 21)
        {
            for(int i=2;i<=9 && j<al.size();i++,j++)
            {   
                String s = "";
                s = Integer.toString(i*1000+i*100+i*10+i);
                hm2.put(al.get(j).ch,s);
            }
        }
       /*
        System.out.println(hm2);
        System.out.println(hm2.size());*/


        int sum = 0;       
        for(char ch : hm2.keySet())
        {
            sum += hm2.get(ch).length() * hm1.get(ch);
        }                
        return sum;
    }

    public static void main(String[] args) 
    {
        System.out.println(minimumPushes("aabbccddeeffgghhiiiiii"));
        System.out.println(minimumPushes("abcde"));
        System.out.println(minimumPushes("xyzxyzxyzxyz"));
        System.out.println(minimumPushes("alporfmdqsbhncwyu"));
    }
    
}
