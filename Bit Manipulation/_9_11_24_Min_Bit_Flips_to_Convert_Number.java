public class _9_11_24_Min_Bit_Flips_to_Convert_Number
{
    public static int minBitFlips(int start, int goal) 
    {
       int xor = start ^ goal;
    
        int count = 0;
        while (xor > 0) 
        {
            count += xor & 1; 
            xor >>= 1; 
        }
    
         return count;
    }
    public static void main(String [] args)
    {
        System.out.println(minBitFlips(10, 7)); 
    }
}