public class _8_15_24_Lemonade_Change 
{
    public static boolean lemonadeChange(int[] bills) 
    {
        int change5 = 0;
        int change10 = 0;
        for(int i=0;i<bills.length;i++)
        {
            if(bills[i] == 5)
            {
                change5++;
            }
            else if(bills[i] == 10)
            {                
                if(change5 >= 1)
                {
                   change10++;
                   change5--;
                }
                else
                {
                    return false;
                }
            }
            else if(bills[i] == 20)
            {                
                if(change5 >= 1 && change10 >= 1)
                {
                    change5--;
                    change10--;
                }
                else if(change5 >= 3 && change10 == 0)
                {
                    change5 -= 3;
                }
                else
                {
                    return false;
                }
            }
        }
        return true;        
    }

    public static void main(String[] args) 
    {
        int [] bills = {5,5,5,10,20};
        System.out.println(lemonadeChange(bills));        
    }
    
}
