public class _8_1_24_Number_of_Senior_Citizens {
    public static int countSeniors(String[] details) 
    {
        int count = 0;

        for(int i =0;i<details.length;i++)
        {
            String s = details[i].substring(11,13);
            int age = Integer.parseInt(s);

            if(age > 60)
            {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) 
    {
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};
        System.out.println(countSeniors(details));
    }
}
