import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _6_18_24_Most_Profit_Assigning_work
{
    public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        
        List<int[]> jobProfile = new ArrayList<>();
        jobProfile.add(new int[]{0,0});

        for(int i=0;i<difficulty.length;i++)
        {
            jobProfile.add(new int[] {difficulty[i],profit[i]});
        }

        Collections.sort(jobProfile,(a,b)->Integer.compare(a[0],b[0]));

        for(int i=0;i<jobProfile.size()-1;i++)
        {
            jobProfile.get(i+1)[1] = Math.max(jobProfile.get(i)[1],jobProfile.get(i+1)[1]);
        }

        int netProfit = 0;
        for(int i=0;i<worker.length;i++)
        {
            int ability = worker[i];

            int l=0, r = jobProfile.size() - 1, jobProfit = 0;

            while(l <= r)
            {
                int mid = (l+r)/2;
                if(jobProfile.get(mid)[0] <= ability)
                {
                    jobProfit = Math.max(jobProfit, jobProfile.get(mid)[1]);
                    l = mid + 1;
                }
                else
                {
                    r = mid - 1;
                }
            }

            netProfit += jobProfit;

        }
        return netProfit;
    }
    public static void main(String [] args)
    {
        int[] difficulty = {2,4,6,8,10};
        int[] profit = {10,20,30,40,50};
        int[] worker = {4,5,6,7};
        System.out.println(maxProfitAssignment(difficulty, profit, worker)); 
    }
}