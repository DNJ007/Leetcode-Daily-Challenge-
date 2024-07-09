public class _7_9_24_Average_Waiting_Time
{
    //T.C : O(n)
    //S.C : O(1)
    public static double averageWaitingTime(int[][] customers) 
    {       
        int currentTime = customers[0][0] + customers[0][1];
        double waitingTime = currentTime - customers[0][0];
        
        for(int i=1;i<customers.length;i++)
        {
            if(customers[i][0] <= currentTime)
            {
                currentTime += customers[i][1];
                waitingTime += currentTime - customers[i][0];
            }

            if(customers[i][0] > currentTime)
            {
                int toBeMinus = customers[i][0] - currentTime;
                currentTime += toBeMinus + customers[i][1];
                waitingTime +=  currentTime - customers[i][0];
            }
        }

       return waitingTime/customers.length;
    }
    public static void main(String [] args)
    {
        int [][] customers = {{1,2},{2,5},{4,3}};
        System.out.println(averageWaitingTime(customers));
        System.out.println(); 
    }
}
