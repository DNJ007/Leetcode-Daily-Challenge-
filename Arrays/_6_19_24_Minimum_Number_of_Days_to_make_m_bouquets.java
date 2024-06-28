public class _6_19_24_Minimum_Number_of_Days_to_make_m_bouquets 
{
    private static int getNumOfBouquets(int[] bloomDay,int mid,int k)
    {
        int numOfBouquets = 0;
        int count = 0;

        for(int i=0;i<bloomDay.length;i++)
        {
            if(bloomDay[i] <= mid)
            {
                count++;
            }
            else
            {
                count = 0;
            }

            if(count == k)
            {
                numOfBouquets++;
                count = 0;
            }
        }
        return numOfBouquets;
    }
    public static int minDays(int[] bloomDay, int m, int k) {

        if(bloomDay.length < m*k)
            return -1;

        int start = 0;
        int end = 0;
        for(int i=0;i<bloomDay.length;i++)  
        {
            end = Math.max(bloomDay[i],end);
        }

        int minDays = -1;

        while(start <= end)
        {
            int mid = (start+end)/2;

            if(getNumOfBouquets(bloomDay, mid, k) >= m)
            {
                minDays = mid;
                end = mid - 1;
            }
            else
            {
                start = mid + 1;
            }
        }

        return minDays;      

    }
    public static void main(String[] args) {
        int []bloomDay = {1,10,3,10,2};
        int m = 3, k = 1;
       System.out.println( minDays(bloomDay,m,k));
    }
}
