import java.util.*;

public class _8_7_24_Integer_to_English_Words
{
    public static HashMap<Integer,String> hm = new HashMap<>();
    public static HashMap<Integer,String> hm2 = new HashMap<>();
    public static HashMap<Integer,String> hm3 = new HashMap<>();
    public static void HashMapInitialization()
    {        
        hm.put(1,"One");
        hm.put(2,"Two");
        hm.put(3,"Three");
        hm.put(4,"Four");
        hm.put(5,"Five");
        hm.put(6,"Six");
        hm.put(7,"Seven");
        hm.put(8,"Eight");
        hm.put(9,"Nine");

        hm2.put(2,"Twenty");
        hm2.put(3,"Thirty");
        hm2.put(4,"Forty");
        hm2.put(5,"Fifty");
        hm2.put(6,"Sixty");
        hm2.put(7,"Seventy");
        hm2.put(8,"Eighty");
        hm2.put(9,"Ninety");

        hm3.put(10,"Ten");
        hm3.put(11,"Eleven");
        hm3.put(12,"Twelve");
        hm3.put(13,"Thirteen");
        hm3.put(14,"Fourteen");
        hm3.put(15,"Fifteen");
        hm3.put(16,"Sixteen");
        hm3.put(17,"Seventeen");
        hm3.put(18,"Eighteen");
        hm3.put(19,"Nineteen");
        

    }

    public static String EnglishWords(int num)
    {
        StringBuilder sb = new StringBuilder("");
        
        int count = 1;
        while(num >= 1)
        {
            int rem = num % 10;
            int originalnum = num;
            num = num/10;

            if((count == 1 || count == 4 || count == 7) && originalnum%100 >= 10 && originalnum%100 <=19)
            {
                int rem2 = originalnum % 100;
                num = num/10;
                
                if(count == 4)
                {                    
                    sb.append("Thousand "); 
                    sb.append(hm3.get(rem2)+" ");                   
                }
                else if (count == 7) {
                    sb.append("Million "); 
                    sb.append(hm3.get(rem2)+" ");
                }
                else
                {
                    sb.append(hm3.get(rem2)+" ");
                }
                count = count + 2;
                continue;
            }
            if(count == 2 || count == 5 || count == 8)
            {
                sb.append(hm2.get(rem));
                sb.append(" ");
                count++;
                continue;
            }

            if((count == 3 || count ==6 || count == 9)&& rem!=0)
            {
                sb.append("Hundred ");
                sb.append(hm.get(rem)+" ");
                count++;
                continue;                
            }

            if(count == 4)
            {
                sb.append("Thousand ");
                sb.append(hm.get(rem)+" ");
                count++;
                continue;
            } 
            
            if(count == 7)
            {
                sb.append("Million ");
                sb.append(hm.get(rem)+" ");
                count++;
                continue;
            }

            if(count == 10)
            {
                sb.append("Billion ");
                sb.append(hm.get(rem)+" ");
                count++;
                continue;
            }
            
            sb.append(hm.get(rem)+" ");           
            count++;            
        }

        String[] s = sb.toString().split(" ");

        for(int i=0,j=s.length-1;i<=j;i++,j--)
        {
            String temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

        List<String> list = new ArrayList<>(Arrays.asList(s));
        list.removeIf("null"::equals);
        s = list.toArray(new String[0]);

        String s1 = "";

        for(int i=0;i<s.length;i++)
        {
            s1+=s[i]+" ";
        }
        return s1;

    }
    public static String numberToWords(int num) 
    {
        if(num == 0)
        {
           String s = "Zero";
           return s;
        }
        if(num == 1000000000)
        {
            String s ="One Billion";
            return s;
        }
        if(num == 1000000001)
        {
            String s ="One Billion One";
            return s;
        }
        HashMapInitialization();
        String word = EnglishWords(num);
        word = word.substring(0, word.length()-1);

        word = removeConsecutive(word);
        return word;
    }

    public static String removeConsecutive(String word)
    {
        String s[] = word.split(" ");

        for(int i=0;i<s.length-1;i++)
        {
            if((s[i].equals("Million") || s[i].equals("Billion"))
            && (s[i+1].equals("Hundred") || s[i+1].equals("Thousand") || s[i+1].equals("Million") || s[i+1].equals("Billion"))) 
            {
                s[i+1] = "null";
            }
        }


        List<String> list = new ArrayList<>(Arrays.asList(s));
        list.removeIf("null"::equals);
        s = list.toArray(new String[0]);

        String s1 = "";

        for(int i=0;i<s.length;i++)
        {
            s1+=s[i]+" ";
        }
        return s1;
    }


    public static void main(String[] args) 
    {
        /*int num = 1234567;
        System.out.println(numberToWords(num));

        int num1 = 123;
        System.out.println(numberToWords(num1));

        int num2 = 12345;
        System.out.println(numberToWords(num2));*/

        /*int num3 = 1234567891;
        System.out.println(numberToWords(num3));*/

        int num4 = 1000000000;
        System.out.println(numberToWords(num4));

        /*
        String s[] = numberToWords(num4).split(" ");

        for(int i=0;i<s.length-1;i++)
        {
            if((s[i].equals("Hundred") || s[i].equals("Thousand") || s[i].equals("Million") || s[i].equals("Billion"))
            && (s[i+1].equals("Hundred") || s[i+1].equals("Thousand") || s[i+1].equals("Million") || s[i+1].equals("Billion"))) 
            {
                s[i+1] = "null";
            }
        }


        List<String> list = new ArrayList<>(Arrays.asList(s));
        list.removeIf("null"::equals);
        s = list.toArray(new String[0]);

        String s1 = "";

        for(int i=0;i<s.length;i++)
        {
            s1+=s[i]+" ";
        }
        System.out.println(s1);*/


    }
}