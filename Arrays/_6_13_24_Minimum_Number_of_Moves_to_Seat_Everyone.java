import java.util.Arrays;

public class _6_13_24_Minimum_Number_of_Moves_to_Seat_Everyone 
{
    public static int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int moves = 0;
        for(int i=0;i<seats.length;i++)
        {
            moves += Math.abs(seats[i] - students[i]);
        }
        return moves;
    }
    public static void main(String[] args) {
        int[] seats = {3,1,5};
        int[] students = {2,7,4};
        System.out.println(minMovesToSeat(seats, students));
    }
}
