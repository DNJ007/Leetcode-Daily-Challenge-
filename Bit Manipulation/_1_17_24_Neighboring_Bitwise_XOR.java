public class _1_17_24_Neighboring_Bitwise_XOR
{
    public static boolean doesValidArrayExist(int[] derived) 
    {
        int XOR = 0;
        for(int num : derived)
        {
            XOR = XOR ^ num;
        }
        return XOR == 0;
    }
    public static void main(String [] args)
    {
        int[] derived = {1,1,0};
        System.out.println(doesValidArrayExist(derived)); 
    }
}