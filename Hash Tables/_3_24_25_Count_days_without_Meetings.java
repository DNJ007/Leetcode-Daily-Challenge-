import java.util.*;
class _3_24_35_Count_days_without_Meetings
{
    public static int countDays(int days, int[][] meetings) 
    {
        TreeMap<Integer,Integer> tm = new TreeMap<>();

        for(int i=0;i<meetings.length;i++)
        {
            int start = meetings[i][0];
            int end = meetings[i][1];
            tm.put(start,tm.getOrDefault(start,0)+1);
            tm.put(end+1,tm.getOrDefault(end+1,0)-1);
        }      

        int count = 0;   
        int prevday = 1;
        int activeMeetings = 0;

        for(int day : tm.keySet())
        {
            if(activeMeetings == 0)
            {
                count += day - prevday;
            }
            activeMeetings += tm.get(day);
            prevday = day;
        }
        
        if (activeMeetings == 0) 
        {
            count += days - prevday + 1;
        }

        return count;
    }
    public static void main(String [] args)
    {
        int days = 10;
        int[][] meetings = {{5,7},{1,3},{9,10}};
        System.out.println(countDays(days, meetings)); 
    }
}