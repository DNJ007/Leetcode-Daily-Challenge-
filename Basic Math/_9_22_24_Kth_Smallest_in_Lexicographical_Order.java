public class _9_22_24_Kth_Smallest_in_Lexicographical_Order 
{
    public static int Count(long curr, long next,int n)
    {
        int countNum = 0;

        while(curr <= n)
        {
            countNum += (next - curr);

            curr *= 10;
            next *= 10;

            next = Math.min(next,(long) n+1);
        }

        return countNum;
    }
    public static int findKthNumber(int n, int k) 
    {
        // T.C : O(log n to base 10)^2
        // S.C : O(log n to base 10)
        int curr = 1;
        k -= 1;

        while(k>0)
        {
            int count = Count (curr,curr+1,n);
            if(count <= k)
            {
                curr++;
                k -= count;
            }
            else
            {
                curr *= 10;
                k -= 1;
            }
        }
        return curr;
    }
    public static void main(String[] args) 
    {
        System.out.println(findKthNumber(13,2));
    }
}
