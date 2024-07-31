import java.util.Arrays;

public class _7_31_24_Filling_Bookcase_Shelves_sol_1
{
    static int n;
    static int WIDTH;
    static int dp[][] = new int[1001][1001];

    public static int solve(int i,int books[][],int remainingWidth, int maxHt)
    {
        //T.C : O(n * shelfWidth)
        //S.C : O(n * shelfWidth) 
        if(i >= n)
        {
            return maxHt;
        }   

        if(dp[i][remainingWidth] != -1)
        {
            return dp[i][remainingWidth];
        }

        int bookH = books[i][1];
        int bookW = books[i][0];

        int Keep = Integer.MAX_VALUE;
        int Skip = Integer.MAX_VALUE; 

        if(bookW <= remainingWidth)
        {
            Keep = solve(i+1,books,remainingWidth - bookW, Math.max(maxHt,bookH));
        }

        Skip = maxHt + solve(i+1,books,WIDTH-bookW,bookH);

        return dp[i][remainingWidth] = Math.min(Keep,Skip);

    }
    public static int minHeightShelves(int[][] books, int shelfWidth) 
    {
        n = books.length;
        WIDTH = shelfWidth;
        for(int i=0;i<dp.length;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        
        int remainW = shelfWidth;
        return solve(0,books,remainW,0);
    }
    public static void main(String [] args)
    {
        int [][] books = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        int shelfWidth = 4;
        System.out.print(minHeightShelves(books, shelfWidth)); 
    }
}
