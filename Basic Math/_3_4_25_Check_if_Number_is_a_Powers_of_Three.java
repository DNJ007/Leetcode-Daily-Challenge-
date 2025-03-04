public class _3_4_25_Check_if_Number_is_a_Powers_of_Three 
{
    public static boolean checkPowersOfThree(int n) 
    {
        int idx = 0;
        int _3powerx = 1;
        while(_3powerx <= n)
        {
            _3powerx = (int)Math.pow(3,idx);
            idx++;
        }
        idx = idx-2;
        while(idx>=0 && n>0)
        {
            if(Math.pow(3,idx) <= n)
            {
                n -= Math.pow(3,idx);
            }            
            idx--;
        }

        if(n==0) return true;

        return false;
    }
    public static void main(String[] args) 
    {
        System.out.println(checkPowersOfThree(91));
        
    }
}
