import java.util.Comparator;
import java.util.TreeMap;

public class _7_22_24_Sort_the_people 
{
    public String[] sortPeople(String[] names, int[] heights) {
        TreeMap<Integer,String> tm = new TreeMap<Integer,String>(Comparator.reverseOrder());

        for(int i =0;i<heights.length;i++)
        {
            tm.put(heights[i],names[i]);
        }
        
        String[] res = new String[names.length];
        int i = 0;
        for(int num : tm.keySet())
        {
            res[i++] = tm.get(num);
        }

        return res;
    }    
}
