public class _12_1_24_Check_If_N_and_Its_Double_Exist 
{
    public static boolean checkIfExist(int[] arr) 
    {
        for(int i=0;i<arr.length;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                if(arr[i] == 2*arr[j])
                {
                    return true;
                }
            }
        }

        for(int i=arr.length-1;i>=1;i--)
        {
            for(int j=i-1;j>=0;j--)
            {
                if(arr[i] == 2*arr[j])
                {
                    return true;
                }
            }
        }  

        return false;
    }

    public static void main(String[] args) 
    {
        int[] arr = {7,1,14,11};
        System.out.println(checkIfExist(arr));
    }
}
