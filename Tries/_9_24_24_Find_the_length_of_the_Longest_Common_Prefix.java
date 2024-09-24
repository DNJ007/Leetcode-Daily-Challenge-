public class _9_24_24_Find_the_length_of_the_Longest_Common_Prefix 
{
    static class Node
    {
        Node children[] = new Node[10];
        boolean eow = false;

        public Node()
        {
            for(int i=0;i<children.length;i++)
            {
                children[i] = null;
            }
        }
    }

    public static Node root = new Node();

    public static void insert(String word)
    {
        Node curr = root;

        for(int i=0;i<word.length();i++)
        {
            int idx = word.charAt(i) - '0';

            if(curr.children[idx] == null)
            {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }


    public static int longestCommonPrefix(int[] arr1, int[] arr2) 
    {
        for(int i=0;i<arr1.length;i++)
        {
            insert(String.valueOf(arr1[i]));
        }

        int maxlength = 0;
        for(int i=0;i<arr2.length;i++)
        {
            int currlength = findMaxPrefix(String.valueOf(arr2[i]));
            maxlength = Math.max(maxlength, currlength);
        }
        return maxlength;
    }

    public static int findMaxPrefix(String word)
    {
        Node curr = root;
        int length = 0;

        for(int i=0;i<word.length();i++)
        {
            int idx = word.charAt(i) - '0';

            if(curr.children[idx] != null)
            {
                length++;
                curr = curr.children[idx];
            }
            else{
                break;
            }
        }
        return length;
    }
    
    public static void main(String[] args) 
    {
        int[] arr1 = {1,10,100};
        int[] arr2 = {1000,4,4,4};
        System.out.println(longestCommonPrefix(arr1, arr2));
        
    }
}
