class TrieNode{
    TrieNode[] children;
    boolean endOfWord;

    TrieNode(){
        children = new TrieNode[26];
        endOfWord = false;
    }
}
class WordDictionary {
    TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c-'a'] == null) curr.children[c-'a'] = new TrieNode();
            curr =  curr.children[c-'a'];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
         return dfs(word,curr,0);
    }
    private boolean dfs(String word, TrieNode curr, int j){
        for(int i=j;i<word.length();i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(TrieNode child : curr.children){
                    if(child != null && dfs(word,child,i+1)){ 
                        return true;
                    }
                }
                return false;
            }else{
                if(curr.children[c-'a'] == null) return false;
                curr = curr.children[c-'a'];
            }
        }
        return curr.endOfWord;
    }
}
