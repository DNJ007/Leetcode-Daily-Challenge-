import java.util.Arrays;

public class _6_20_24_Magnetic_Force_Between_Two_Balls {
    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int start = 1;
        int end = position[position.length-1]-position[0];

        int ans = 1;
        
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(isPossible(mid,position,m))
            {
                ans = mid;
                start = mid+1;
            }
            else
            {
                end = mid-1;
            }                
        }
        return ans;
    }

    private static boolean isPossible(int mid,int[] position,int m)
    {
        int prev = position[0];
        m-=1;
        for(int i=1;i<position.length;i++)
        {
            if(position[i] - prev >= mid)
            {
                m-=1;
                prev = position[i];
            }
            if(m==0) return true;            
        }
        return false;
    }

    public static void main(String[] args) {
        int position[] = {1,2,3,4,7}; int m = 3;
        System.out.println(maxDistance(position, m));
    }
}
