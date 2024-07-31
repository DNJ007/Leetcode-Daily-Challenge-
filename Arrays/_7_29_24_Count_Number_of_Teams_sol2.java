public class _7_29_24_Count_Number_of_Teams_sol2 
{
    public static int numTeams(int[] rating) 
    {
       int[] lessThanLeft = new int[rating.length];
       int[] lessThanRight = new int[rating.length];
       int[] greaterThanLeft = new int[rating.length];
       int[] greaterThanRight = new int[rating.length];

       for(int i=0;i<rating.length;i++)
       {
            int less = 0,greater = 0;
            for(int j=0;j<i;j++)
            {
                if(rating[j]<rating[i])
                {
                    less++;
                }
                else
                {
                    greater++;
                }
            }

            lessThanLeft[i] = less;
            greaterThanLeft[i] = greater;
            less = 0;
            greater = 0;


            for(int j=i+1;j<rating.length;j++)
            {
                if(rating[j] < rating[i])
                {
                    less++;
                }
                else
                {
                    greater++;
                }
            }
            lessThanRight[i] = less;
            greaterThanRight[i] = greater;
       }
       int count = 0;
       for(int i=0;i<rating.length;i++)
       {
           count += lessThanLeft[i] * greaterThanRight[i];
           count += lessThanRight[i] * greaterThanLeft[i];
       }
       return count;       
    }

    public static void main(String[] args) 
    {
        int[] rating = {2,5,3,4,1};
        System.out.println(numTeams(rating)); 
        
    }
    
}
