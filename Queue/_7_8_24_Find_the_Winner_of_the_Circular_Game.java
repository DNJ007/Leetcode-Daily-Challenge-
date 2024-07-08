import java.util.LinkedList;
import java.util.Queue;

public class _7_8_24_Find_the_Winner_of_the_Circular_Game 
{
    // T.C : O(n)
    // S.C : O(n)
    public static int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<Integer>();

        for(int i=1;i<=n;i++)
        {
            q.add(i);
        }

        while(q.size() != 1)
        {
            int count = 0;
            while(count!=k-1)
            {                
                q.add(q.remove());
                count++;
            }
            if(count == k-1)
            {
                q.remove();
            }
        }

        return q.peek();
    }
    public static void main(String[] args) {
        int n = 5, k = 2;
        System.out.print(findTheWinner(n, k));
    }
}
