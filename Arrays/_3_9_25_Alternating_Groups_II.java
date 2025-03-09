public class _3_9_25_Alternating_Groups_II 
{  
    public static int numberOfAlternatingGroups(int[] colors, int k) 
    {
            int ans = 0;
            int i = 0;
            int j = 1;
            int n = colors.length;
    
            int[] doublecolors = new int[n+k-1];
            for(int l=0;l<n+k-1;l++)
            {
                doublecolors[l] = colors[l%n];
            }
            int prev = doublecolors[i];
    
            while(j<n+k-1)
            {
                if((prev == 0 && doublecolors[j] == 1) || (prev == 1 && doublecolors[j] == 0))
                {               
                    if(j-i+1 == k)
                    {
                        ans++;
                        i++;
                    }
                    prev = doublecolors[j];
                    j++;
                }
                else
                {
                    i = j;
                    prev = doublecolors[i];
                    j++;  
                }          
            }                
            return ans;
    }
    public static void main(String[] args) 
    {
        int[]colors = {0,1,0,0,1,0,1};
        int k = 6;

        System.out.println(numberOfAlternatingGroups(colors, k));
    }
}
