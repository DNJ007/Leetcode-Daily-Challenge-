import java.util.ArrayList;
import java.util.List;

public class _9_27_24_My_Calender_II 
{
     class Event 
    {
        int start;
        int end;
        Event(int start,int end)
        {
            this.start = start;
            this.end = end;
        }
    }

    private ArrayList<Event> events;
    private List<Event> overlaps;
    

    public _9_27_24_My_Calender_II() 
    {
        events = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int start, int end) 
    {
        Event newEvent = new Event(start, end);

        for (Event overlap : overlaps) 
        {
            if (newEvent.start < overlap.end && newEvent.end > overlap.start) 
            {
                return false;  // Triple booking detected.
            }
        }
        for (Event event : events) 
        {
            if (newEvent.start < event.end && newEvent.end > event.start) 
            {
                int overlapStart = Math.max(newEvent.start, event.start);
                int overlapEnd = Math.min(newEvent.end, event.end);
                overlaps.add(new Event(overlapStart, overlapEnd));
            }
        }
        events.add(newEvent);
        return true;     
    }

    public static void main(String[] args) 
    {
        _9_27_24_My_Calender_II myCalendarTwo = new _9_27_24_My_Calender_II();
        System.out.println(myCalendarTwo.book(10,20));
        System.out.println(myCalendarTwo.book(50, 60)); // return True, The event can be booked. 
        System.out.println(myCalendarTwo.book(10, 40)); // return True, The event can be double booked. 
        System.out.println(myCalendarTwo.book(5, 15));  // return False, The event cannot be booked, because it would result in a triple booking.
        System.out.println(myCalendarTwo.book(5, 10)); // return True, The event can be booked, as it does not use time 10 which is already double booked.
        System.out.println(myCalendarTwo.book(25, 55)); // return True, The event can be booked, as the time in [25, 40) will be double booked with the third event, the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.
                
    }
    
}
