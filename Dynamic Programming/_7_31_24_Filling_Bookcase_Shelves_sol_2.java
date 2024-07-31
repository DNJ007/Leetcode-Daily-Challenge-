public class _7_31_24_Filling_Bookcase_Shelves_sol_2 
{
    private static int arrangeBooks(int[][] books,int maxShelfWidth)
    {
        //T.C : O(n^2)
        //S.C : O(n) 
        int[] minHeights = new int[books.length + 1];

        for(int idx = 1; idx <= books.length;idx++)
        {
            minHeights[idx] = Integer.MAX_VALUE;
            int currentShelfHeight = 0;
            int currentShelfWidth = 0;

            for(int lastidx = idx-1; lastidx >= 0; lastidx--)
            {
                int currentBookWidth = books[lastidx][0];
                int currentBookHeight = books[lastidx][1];

                if(currentShelfWidth + currentBookWidth > maxShelfWidth)
                {
                    break;
                }

                currentShelfWidth += currentBookWidth;
                currentShelfHeight = Math.max(currentShelfHeight, currentBookHeight);

                int currentArrangementHeight = minHeights[lastidx] + currentShelfHeight;
                minHeights[idx] = Math.min(minHeights[idx],currentArrangementHeight);
            }
        }
        return minHeights[books.length];
        
    }
    public static int minHeightShelves(int[][] books, int shelfWidth) 
    {
        return arrangeBooks(books,shelfWidth);
    }

    public static void main(String[] args) 
    {
        int [][] books = {{1,1},{2,3},{2,3},{1,1},{1,1},{1,1},{1,2}};
        int shelfWidth = 4;
        System.out.print(minHeightShelves(books, shelfWidth)); 
    }
    
}
