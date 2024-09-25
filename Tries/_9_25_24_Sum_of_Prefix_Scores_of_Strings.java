public class _9_25_24_Sum_of_Prefix_Scores_of_Strings 
{
    static class Node
    {
        Node children[] = new Node[26];
        Boolean eow ;
        int freq;

        public Node()
        {
            freq = 0;
        }        
    }

    public static Node root = new Node();

    public static void insert(String word)
    {
        Node curr = root;
        for(int i=0;i<word.length();i++)
        {
            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null)
            {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
            curr.freq++; 
        }
    }

    public static int getPrefixScore(String word)
    {
        Node curr = root;
        int score = 0;
        
        for(int i=0;i<word.length();i++)
        {
            int idx = word.charAt(i) - 'a';

            if(curr.children[idx] == null)
            {
                break;
            }
            curr = curr.children[idx];
            score += curr.freq;
        }
        return score;
    }
    public static int[] sumPrefixScores(String[] words) 
    {

        for(String word : words)
        {
            insert(word);
        }

        int score[] = new int[words.length];
        for(int i=0;i<words.length;i++)
        {
           score[i] = getPrefixScore(words[i]);
        }
        return score;
    }

    public static void main(String[] args) 
    {
        String []words = {"abc","ab","bc","b"};
        int [] scores = sumPrefixScores(words);
        
        for(int i=0;i<scores.length;i++)
        {
            System.out.print(scores[i]+" ");
        }
    }
}
