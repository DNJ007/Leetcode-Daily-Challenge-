public class _3_16_25_Minimum_Time_to_Repair_Cars 
{
    public static boolean isPossible(int[] ranks,long mid,int cars)
    {
        long carsFixed = 0;
        for(int i=0;i<ranks.length;i++)
        {
            carsFixed += Math.sqrt(mid/ranks[i]);
        }
        return carsFixed >= cars;
    }
    public static long repairCars(int[] ranks, int cars) 
    {
        long l = 1;
        long max = 0;
        for(int i=0;i<ranks.length;i++)
        {
            max = Math.max(ranks[i],max);
        }
        long r = max * cars * cars;

        long ans = -1;

        //T.C : O(N* log(max*cars*cars))
        while(l<=r)
        {
            long mid = l + (r-l)/2;

            if(isPossible(ranks,mid,cars))
            {
                ans = mid;
                r = mid - 1;
            }
            else
            {
                l = mid + 1;
            }
        }
        return ans;
    }  
}
