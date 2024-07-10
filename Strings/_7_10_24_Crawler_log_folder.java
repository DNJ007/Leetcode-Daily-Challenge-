public class _7_10_24_Crawler_log_folder {
    public static int minOperations(String[] logs) {
        int operations = 0;

        for(int i=0;i<logs.length;i++)
        {
            if(logs[i].equals("./"))
            {
                continue;
            }
            else if(logs[i].charAt(0) == '.' && logs[i].charAt(1) == '.' && logs[i].charAt(2) == '/')
            {
                if(operations > 0)
                {
                    operations--;
                }
            }
            else
            {
                operations++;
            }

        }
        return operations;
    }
    public static void main(String[] args) {
        String [] logs = {"d1/","d2/","../","d21/","./"};
        System.out.println(minOperations(logs));
    }
}
