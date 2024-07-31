public class _7_29_24_Count_Number_of_Teams_sol1
{
    public static int numTeams(int[] rating) 
    {
        int ans = 0;
       for(int i=0;i<rating.length;i++)
       {
        for(int j=i+1;j<rating.length;j++)
        {
            for(int k=j+1;k<rating.length;k++)
            {
                if(rating[i] < rating[j] &&  rating[j] < rating[k])
                {
                    ans++;
                }
                if(rating[i] > rating[j] && rating[j] > rating[k])
                {
                    ans++;
                }
            }   
        }
       }
       return ans;       
    }
    public static void main(String [] args)
    {
        int[] rating = {2,5,3,4,1};
        System.out.println(numTeams(rating)); 
    }
}