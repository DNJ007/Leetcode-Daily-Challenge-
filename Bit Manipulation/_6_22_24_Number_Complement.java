public class _6_22_24_Number_Complement 
{
    public static int findComplement(int num) 
    {
        int bitmask = (Integer.highestOneBit(num) << 1) - 1;
        return num ^ bitmask;
    }

    public static void main(String[] args) 
    {
        System.out.println(findComplement(5));
    }    
}
