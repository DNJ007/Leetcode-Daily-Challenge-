public class _7_6_24_Pass_the_Pillow 
{
    public static int passThePillow(int n, int time) 
    {
        int count = 0;
        int index = -1;
        while(count != time)
        {
            for(int i=2;i<=n;i++)
            {
                count++;
                if(count == time)
                {
                    index = i;
                    break;
                }
            }

            if(count == time)
            {
                break;
            }

            for(int i = n-1;i>=1;i--)
            {
                count++;
                if(count == time)
                {
                    index = i;                    
                    break;
                }
            }
            if(count == time)
                {
                    break;
                }
        }
        return index;
    }
    public static void main(String[] args) {
        int n = 4, time = 5;
        System.out.println(passThePillow(n, time));
    }
}
