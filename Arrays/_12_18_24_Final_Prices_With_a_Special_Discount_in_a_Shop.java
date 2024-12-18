public class _12_18_24_Final_Prices_With_a_Special_Discount_in_a_Shop
{
    public static int[] finalPrices(int[] prices) 
    {
        int i=0;
        int res[] = new int[prices.length];
        res = prices;
        while(i<prices.length)
        {
            int j=i+1;
            while(j<prices.length && prices[j] > prices[i])
                j++;
            
            if(j<prices.length)
            {
                res[i] = prices[i] - prices[j];
            }

            i++;
        }

        return res;
        
    }
    public static void main(String [] args)
    {
        int [] prices = {8,4,6,2,3};
        prices = finalPrices(prices);
        for(int i=0;i<prices.length;i++)
        {
            System.out.print(prices[i]+" ");
        }
        
    }
}