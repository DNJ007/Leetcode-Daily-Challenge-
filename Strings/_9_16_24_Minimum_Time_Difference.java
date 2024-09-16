import java.util.*;

public class _9_16_24_Minimum_Time_Difference
{
    public static int optimizedfindMinDifference(List<String> timePoints) 
    {
        int[] minutes= new int[timePoints.size()];

        for(int i=0;i<timePoints.size();i++)
        {
            String time = timePoints.get(i);
            int h = Integer.parseInt(time.substring(0, 2));
            int m = Integer.parseInt(time.substring(3));

            minutes[i] = h * 60 + m;
        }

        Arrays.sort(minutes);

        int min = Integer.MAX_VALUE;
        for(int i=0;i<minutes.length-1;i++)
        {
            int diff = Math.abs(minutes[i] - minutes[i+1]);

            min = Math.min(min,Math.min(diff,1440-diff));
        }

        int diff = Math.abs(minutes[0] - minutes[minutes.length-1]);
        min = Math.min(min,Math.min(diff,1440-diff));
        return min;
    }
    public static int findMinDifference(List<String> timePoints) 
    {
        List<Integer> Al= new ArrayList<>();
        String[] str = new String[2];

        for(int i=0;i<timePoints.size();i++)
        {
            String s = timePoints.get(i);
            str = s.split(":");
            if(Integer.parseInt(str[0]) == 00)
            {
                str[0] = String.valueOf(24);
            }

            int min = (Integer.parseInt(str[0]) * 60) + Integer.parseInt(str[1]);
            Al.add(min);
        }

        Collections.sort(Al);

        int min = Integer.MAX_VALUE;
        for(int i=0;i<Al.size()-1;i++)
        {
            int diff = Math.abs(Al.get(i) - Al.get(i+1));

            min = Math.min(min,diff);
        }
        int diff = Math.abs(Al.get(0) - Al.get(Al.size()-1));
        min = Math.min(min,Math.min(diff,1440-diff));
        return min;
    }
    public static void main(String [] args)
    {
        List<String> timePoints = new ArrayList<>();
        timePoints.add("00:00");
        timePoints.add("23:59");
        timePoints.add("00:00");
        System.out.println(findMinDifference(timePoints)); 
        System.out.println(optimizedfindMinDifference(timePoints)); 
    }
}
