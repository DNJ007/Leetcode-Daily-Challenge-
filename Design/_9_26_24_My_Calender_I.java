import java.util.ArrayList;
import java.util.Collections;

public class _9_26_24_My_Calender_I 
{   

    static class Event implements Comparable<Event>
    {
        int start;
        int end;
        Event(int start, int end)
        {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Event o2)
        {
            return Integer.compare(this.start, o2.end);
        }
    }

    private ArrayList<Event> events;

    public _9_26_24_My_Calender_I() {
        events = new ArrayList<>();
    }

    public boolean book(int start, int end) 
    {
        Event newEvent = new Event(start, end);
        for (Event event : events) 
        {
            if (newEvent.start < event.end && newEvent.end > event.start) {
                return false; 
            }
        }
        events.add(newEvent);
        Collections.sort(events); 
        return true;


    }
    public static void main(String[] args) 
    {
        _9_26_24_My_Calender_I obj = new _9_26_24_My_Calender_I();
        obj.book(47,50);
        System.out.println(obj.book(33,41));
        System.out.println(obj.book(39,45));
        System.out.println(obj.book(33,42));
        System.out.println(obj.book(25,32));
        System.out.println(obj.book(26,35));
        System.out.println(obj.book(19,25));
        System.out.println(obj.book(3,8));
        System.out.println(obj.book(8,13));
        System.out.println(obj.book(18,27));
        

    }


    
}
