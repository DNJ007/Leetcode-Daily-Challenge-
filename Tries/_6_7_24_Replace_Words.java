import java.util.ArrayList;
import java.util.List;

public class _6_7_24_Replace_Words
{
    static class Node{
        Node[] children = new Node[26];
        boolean eow;

        public Node(){
            for(int i=0;i<children.length;i++)
            {
                children[i] = null;
            }
            eow = false;
        }
    }

    static class Trie
    {
        private Node root;
        public Trie()
        {
            root = new Node();
        }

        public void insert(String word)
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
            }
            curr.eow = true;
        }

        public String shortestRoot(String word)
        {
            Node curr = root;

            for(int i=0;i<word.length();i++)
            {
                int idx = word.charAt(i) - 'a';
                if(curr.children[idx] == null)
                {
                    return word;
                }
                curr = curr.children[idx];

                if(curr.eow)
                {
                    return word.substring(0,i+1);
                }
            }
            return word;
        }
    }


    public static String replaceWords(List<String> dictionary, String sentence) {
        String[] wordlist = sentence.split(" ");

        Trie dictTrie = new Trie();
        for(String word : dictionary)
        {
            dictTrie.insert(word);
        }

        for(int word=0;word<wordlist.length;word++)
        {
            wordlist[word] = dictTrie.shortestRoot(wordlist[word]);
        }

        return String.join(" ", wordlist);
    }
    public static void main(String [] args)
    {
        ArrayList<String> dictionary = new ArrayList<String>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        System.out.println(replaceWords(dictionary, sentence)); 
    }
}