public class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}
public class PrefixTree {
    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()){

            if(curr.children[c - 'a'] == null){
                TrieNode newNode = new TrieNode();
                curr.children[c-'a'] = newNode;
            }
            curr = curr.children[c-'a'];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;

        for(char c : word.toCharArray()){

            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;

        for(char c : prefix.toCharArray()){

            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c-'a'];
        }
        return true;
    }
}
