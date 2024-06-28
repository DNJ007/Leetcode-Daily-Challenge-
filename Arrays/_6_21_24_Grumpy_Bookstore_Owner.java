public class _6_21_24_Grumpy_Bookstore_Owner
{
    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int unrealizedCustomers = 0;

        for(int i=0;i<minutes;i++)
        {
            if(grumpy[i] == 1)
                unrealizedCustomers += customers[i] ;
        }

        int maxUnrealizedCustomers = unrealizedCustomers;

        for(int i=minutes;i<customers.length;i++)
        {
            unrealizedCustomers += customers[i] * grumpy[i];
            unrealizedCustomers -= customers[i - minutes] * grumpy[i-minutes];

            maxUnrealizedCustomers = Math.max(maxUnrealizedCustomers, unrealizedCustomers);
        }

        int totalCustomers = maxUnrealizedCustomers;

        for(int i=0;i<customers.length;i++)
        {
            if(grumpy[i]==0)
                totalCustomers += customers[i];
        }

        return totalCustomers;
    }
    public static void main(String [] args)
    {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;
        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }
}