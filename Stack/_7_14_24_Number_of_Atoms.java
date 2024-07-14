import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;

public class _7_14_24_Number_of_Atoms 
{
    public static String countOfAtoms(String formula) 
    {
        //T.C : O(n log m)
        //S.C : O(n + m)
        Map<String,Integer> tm = new TreeMap<>();
        Stack<Map<String, Integer>> s = new Stack<>();

        int n = formula.length();
        int i = 0;
       
       while(i < n)
       {
            char c = formula.charAt(i);

            if(c == '(')
            {
                s.push(tm);
                tm = new TreeMap<>();
                i++; 
            }
            else if(c == ')')
            {
               int iStart = ++i;
               int multiplicity = 1;               

               while((i<n) && Character.isDigit(formula.charAt(i)))
               {
                    i++;
               }

               if(i > iStart)
               {
                    multiplicity = Integer.parseInt(formula.substring(iStart,i));
               }

               if(!s.isEmpty())
               {
                    Map<String,Integer> temp = tm;
                    tm = s.pop();

                    for(String key : temp.keySet())
                    {
                        tm.put(key, tm.getOrDefault(key,0) + temp.get(key) * multiplicity);
                    }
               }
            }
            else
            {
                int iStart = i++;

                while(i<n && Character.isLowerCase(formula.charAt(i)))
                {
                    i++;
                }
                String name = formula.substring(iStart,i);
                iStart = i;

                while(i<n && Character.isDigit(formula.charAt(i)))
                {
                    i++;
                }

                int multiplicity = (i > iStart) ? Integer.parseInt(formula.substring(iStart,i)) : 1;

                tm.put(name, tm.getOrDefault(name,0) + multiplicity);
            }
       }

       StringBuilder sb = new StringBuilder();

       for(String key : tm.keySet())
       {
            sb.append(key);
            int count = tm.get(key);
            if(count > 1)
            {
                sb.append(count);
            }
       }
       return sb.toString();

    }
    public static void main(String[] args) {
        String formula = "K4(ON(SO3)2)2";
        System.out.println(countOfAtoms(formula));
    }
}
