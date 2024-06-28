public class _5_30_24_Number_of_steps_to_reduce_a_number_in_binary_representation_to_one {
    public static int numSteps(String s) {
        int res = 0, carry = 0;

        for(int i = s.length() - 1; i> 0; i--){
            res++;
            if(s.charAt(i) - '0' + carry == 1){
                carry = 1;
                res ++;
            }

        }
        return res + carry;    
    }
    public static void main(String[] args) {
        String s = "1101";
        System.out.println(numSteps(s));
    }
}
