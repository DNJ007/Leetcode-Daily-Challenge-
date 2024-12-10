public class _12_10_24_Find_Longest_Special_Substring_That_Occurs_Thrice_II 
{
    public static int maximumLength(String s) 
    {
        int n = s.length();
          int[][] mat = new int[26][n+1];
  
          char prev = s.charAt(0);
          int len = 0;
          for(int i=0;i<n;i++)
          {
              char curr = s.charAt(i);
              if(curr == prev)
              {
                  len++;
                  mat[curr-'a'][len] += 1;
              }
              else
              {
                  len = 1;
                  mat[curr-'a'][len] += 1;
                  prev = curr;
              }
          }
  
          int res = 0;
          for(int i=0;i<26;i++)
          {
              int cumSum = 0;
              for(int j=n;j>=1;j--)
              {
                  cumSum += mat[i][j];
                  if(cumSum >= 3)
                  {
                      res = Math.max(res, j);
                      break;
                  }
              }
          }
  
          return res == 0 ? -1 : res;
      }

      public static void main(String[] args) 
      {
         String s = "aaaa";
         System.out.println(maximumLength(s));
      }
}

