public class _10_19_24_Find_Kth_Bit_in_Nth_Binary_String 
{
    public static char findKthBit(int n, int k) 
    {
        //T.C : O(n)
        //S.C : O(n)
        if(n == 1)
        {
            return '0';
        }
        int length = (1 << n) - 1;

        if(k < Math.ceil(length/2.0))
        {
            return findKthBit(n-1,k);
        }
        else if(k == Math.ceil(length/2.0))
        {
            return '1';
        }
        else
        {
            char ch = findKthBit(n-1,length-(k-1));
            return (ch == '0') ? '1' : '0';
        }
    }
    public static void main(String[] args) {
        System.out.println(findKthBit(3, 1));
    }
    
}
