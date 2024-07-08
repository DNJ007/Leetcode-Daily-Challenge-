public class _7_8_24_Find_the_Winner_of_the_Circular_Game_Much_Optimized 
{
    public static int findTheWinner(int n, int k) 
    {
        //T.C : O(n)
        //S.C : O(n)
        int ans = 0;
        for(int i=2;i<=n;i++)
        {
             ans = (ans+k)%i;
        }
        return ans + 1;
    }
    
    public static void main(String[] args) 
    {
        int n = 5, k = 2;
        System.out.print(findTheWinner(n, k));
    }
}
