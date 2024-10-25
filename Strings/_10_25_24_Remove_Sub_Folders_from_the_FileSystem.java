import java.util.*;
public class _10_25_24_Remove_Sub_Folders_from_the_FileSystem
{
    public static List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);

        List<String> res = new ArrayList<>();
        res.add(folder[0]);

        for(int i=1;i<folder.length;i++)
        {
            String lastFolder = res.get(res.size() - 1);
            lastFolder += '/';

            if(!folder[i].startsWith(lastFolder))
            {
                res.add(folder[i]);
            }
        }

        return res;
    }
    public static void main(String [] args)
    {
        String folder[] = {"/a","/a/b","/c/d","/c/d/e","/c/f"};

        System.out.println(removeSubfolders(folder)); 
    }
}