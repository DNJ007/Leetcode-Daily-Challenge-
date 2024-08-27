public class _8_23_24_Fraction_Addition_and_Subtraction 
{
    public static String fractionAddition(String expression) 
    {
        int num = 0;
        int den = 1;

        int i = 0;
        int n = expression.length();

        while (i < n) 
        {
            int currNum = 0;
            int currDen = 0;

            boolean isNeg = (expression.charAt(i) == '-');

            if (expression.charAt(i) == '+' || expression.charAt(i) == '-') 
            {
                i++;
            }

            // Parse numerator
            while (i < n && Character.isDigit(expression.charAt(i))) 
            {
                int val = expression.charAt(i) - '0';
                currNum = (currNum * 10) + val;
                i++;
            }

            i++; // Skip the '/' character

            // If it's a negative fraction
            if (isNeg) 
            {
                currNum *= -1;
            }

            // Parse denominator
            while (i < n && Character.isDigit(expression.charAt(i))) 
            {
                int val = expression.charAt(i) - '0';
                currDen = (currDen * 10) + val;
                i++;
            }

            // Add the fraction to the total
            num = num * currDen + currNum * den;
            den = den * currDen;
        }

        // Simplify the result by the greatest common divisor (GCD)
        int gcd = gcd(Math.abs(num), Math.abs(den));
        num /= gcd;
        den /= gcd;

        // If the denominator is negative, make it positive and adjust numerator
        if (den < 0) 
        {
            den = -den;
            num = -num;
        }

        return num + "/" + den;
    }

    // Helper method to calculate GCD
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        String expression = "-1/2+1/2";
        System.out.println(fractionAddition(expression));
    }
}
