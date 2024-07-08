public class _7_7_24_Water_Bottles {
    public static int numWaterBottles(int numBottles, int numExchange)
    {
        if(numBottles < numExchange)
        {
            return numBottles;
        }
        int bottles = numBottles;
        int totalBottles = numBottles;

        while(bottles >= numExchange)
        {
            int newbottles = bottles/numExchange;             
            totalBottles += newbottles;
            bottles = newbottles + (bottles%numExchange);        
        }       

        return totalBottles;
    }
    public static void main(String[] args) {
        int numBottles = 9;
        int numExchange = 3;
        System.out.println(numWaterBottles(numBottles, numExchange));
    
    }
}
