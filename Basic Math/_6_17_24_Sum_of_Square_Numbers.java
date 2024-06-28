public class _6_17_24_Sum_of_Square_Numbers
{
    public static boolean judgeSquareSum(int c) 
    {
        long b=(long)Math.ceil(Math.pow(c,0.5));
        long a=0;
        while(a<=b){
            long val=a*a+b*b;
            if(val==c){
                return true;
            }else if(val>c){
                b--;
            }else{
                a++;
            }            
        }
        return false;
    }
    public static void main(String [] args)
    {
        System.out.println(judgeSquareSum(3)); 
    }
}