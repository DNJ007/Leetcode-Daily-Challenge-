import java.util.Arrays;

public class _10_4_24_Divide_Players_Into_Teams_of_Equal_Skill
{
    public static long dividePlayers(int[] skill) 
    {
        int sum = 0;
        Arrays.sort(skill);
        for(int num : skill)
        {
            sum += num;            
        }

        int n = skill.length;
        int m = n/2;
        
        if (sum % m != 0) {
            return -1;
        }

        int sk = sum / m;
        long res = 0;

        for(int i=0;i<m;i++)
        {
            int j = n-i-1;
            if(skill[i]+skill[j] != sk)
            {
                return -1;
            }
            res += skill[i] * skill[j];
        }

        return res;
    }
    public static void main(String [] args)
    {
        int [] skill = {3,2,5,1,3,4};
        System.out.println(dividePlayers(skill)); 
    }
}