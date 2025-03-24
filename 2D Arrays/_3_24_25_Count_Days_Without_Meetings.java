import java.util.*;
class _3_24_35_Count_Days_Without_Meetings
{
    public static int countDays(int days, int[][] meetings) 
    {
        Arrays.sort(meetings,(a,b)->Integer.compare(a[0],b[0]));
        int count = 0;
        int maxEnd = 0;

        for(int[] meeting : meetings)
        {
            int start = meeting[0];
            int end = meeting[1];

            if(start > maxEnd + 1)
            {
                count += start - maxEnd - 1;
            }
            maxEnd = Math.max(maxEnd,end);
        }

        if(maxEnd < days)
        {
            count += days - maxEnd;
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