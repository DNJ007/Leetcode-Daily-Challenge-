class _1_6_25_Min_no_of_Operations_to_move_all_balls_to_each_box
{
    public static int[] minOperations(String boxes) 
    {
        int[] res = new int[boxes.length()];

        int cumValue = 0;
        int cumValueSum = 0;

        for(int i=0;i<boxes.length();i++)
        {
            res[i] = cumValueSum;
            cumValue += boxes.charAt(i) == '0' ? 0 : 1;
            cumValueSum += cumValue;
        }

        cumValue = 0;
        cumValueSum = 0;

        for(int i=boxes.length()-1;i>=0;i--)
        {
            res[i] += cumValueSum;
            cumValue += boxes.charAt(i) == '0' ? 0 : 1;
            cumValueSum += cumValue;
        }

        return res;
    }
    public static void main(String [] args)
    {
        int[] res = minOperations("001011");
        for(int i=0;i<res.length;i++)
        {
            System.out.print(res[i]+" ");
        } 
    }
}