import java.util.*;

public class _10_25_24_Remove_Sub_Folders_from_the_Filesystem
{
    class Node{
        HashMap<String, Node> children;
        boolean eow;

        public Node()
        {
            this.eow=false;
            this.children = new HashMap<>();
        }
    }

    public Node root = new Node();

    public _10_25_24_Remove_Sub_Folders_from_the_Filesystem() {
        this.root = new Node();
    }

    public void insert(String path)
    {
        Node curr = root;
        String[] foldernames = path.split("/");

        for(String folderName : foldernames)
        {
            if(folderName.equals("")) 
                continue;

            if(!curr.children.containsKey(folderName))
            {
                curr.children.put(folderName, new Node());
            }
            curr = curr.children.get(folderName);
        }
        curr.eow = true;
    }

    public boolean isSubFolder(String path)
    {
        Node curr = root;
        String[] folderNames = path.split("/");

        for(int i=0;i<folderNames.length;i++)
        {
            if(folderNames[i].equals(""))
                continue;
            
            Node nextNode = curr.children.get(folderNames[i]);

            if(nextNode.eow && i != folderNames.length-1)
            {
                return true;
            }
            curr = nextNode;
        }
        return false;
    }

    public List<String> removeSubfolders(String[] folder) 
    {

        for(String path : folder)
        {
            insert(path);
        }

        List<String> res = new ArrayList<>();
       
        for(String path : folder)
        {
            if(!isSubFolder(path))
            {
                res.add(path);
            }
        }     
        
        return res;
    }
    public static void main(String [] args)
    {
        _10_25_24_Remove_Sub_Folders_from_the_Filesystem obj = new _10_25_24_Remove_Sub_Folders_from_the_Filesystem();
        _10_25_24_Remove_Sub_Folders_from_the_Filesystem obj2 = new _10_25_24_Remove_Sub_Folders_from_the_Filesystem();
        
        String []folder = {"/a","/a/b","/c/d","/c/d/e","/c/f"};
        System.out.println(obj.removeSubfolders(folder)); 

        String folder2[] = {"/a/b/c","/a/b/ca","/a/b/d"};
        System.out.println(obj2.removeSubfolders(folder2));
    }
}