import java.util.HashMap;
import java.util.Map;

class TrieNode 
{
    Map<Character, TrieNode> children = new HashMap();
    boolean is_word = false;
}

class _9_23_24_Extra_Characters_in_a_String 
{
    static TrieNode root;
    static Integer[] memo;
    public static int minExtraChar(String s, String[] dictionary) 
    {
        int n = s.length();
        root = buildTrie(dictionary);
        memo = new Integer[n + 1];
        return dp(0, n, s);
    }
    
    private static int dp(int start, int n, String s) 
    {
        if (start == n) 
        {
            return 0;
        }
        if (memo[start] != null) 
        {
            return memo[start];
        }

        TrieNode node = root;
        // To count this character as a left over character 
        // move to index 'start + 1'
        int ans = dp(start + 1, n, s) + 1;
        for (int end = start; end < n; end++) 
        {
            char c = s.charAt(end);
            if (!node.children.containsKey(c)) 
            {
                break;
            }
            node = node.children.get(c);
            if (node.is_word) 
            {
                ans = Math.min(ans, dp(end + 1, n, s));
            }
        }
        
        return memo[start] = ans;
    }
    
    private static TrieNode buildTrie(String[] dictionary) 
    {
        TrieNode root = new TrieNode();
        for (String word : dictionary) 
        {
            TrieNode node = root;
            for (char c : word.toCharArray()) 
            {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.is_word = true;
        }
        return root;
    }
    public static void main(String[] args) 
    {
        String s = "leetscode";
        String[] dictionary = {"leet","code","leetcode"};
        System.out.println(minExtraChar(s,dictionary));
        
    }
}
