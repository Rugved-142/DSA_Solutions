class TrieNode{
    TrieNode[] children;
    int idx = -1;
    int refs = 0;

    TrieNode(){
        children = new TrieNode[26];
    }

    void addWord(String word, int i){
        TrieNode curr = this;
        for(char c : word.toCharArray()){
            if(curr.children[c-'a'] == null) 
                curr.children[c-'a']= new TrieNode();
            curr = curr.children[c-'a'];
            curr.refs++;
        }
        curr.idx = i;
    }
}
class Solution {
    int ROWS, COLS;
    List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        for(int i=0;i<words.length;i++){
            root.addWord(words[i],i);
        }

        ROWS = board.length;
        COLS = board[0].length;
        for(int r=0;r < ROWS;r++){
            for(int c=0;c < COLS;c++){
                dfs(board,words,root,r,c);   
            }
        }

        return res;
    }

    private int dfs(char[][] board, String[] words, TrieNode node,int row, int col){
        if(row < 0 || col < 0 || row >= ROWS || col >= COLS
        || board[row][col] == '*' || node.children[board[row][col]-'a'] == null) {
            return 0;
        }


        char temp = board[row][col];
        board[row][col] ='*';

        TrieNode prev = node;
        node = node.children[temp - 'a'];
        int found = 0;
        if(node.idx != -1){
            res.add(words[node.idx]);
            node.idx=-1;
            found ++;
        }

        found += dfs(board, words, node, row + 1,col);
        found += dfs(board, words, node, row - 1,col);
        found += dfs(board, words, node, row ,col + 1); 
        found += dfs(board, words, node, row ,col - 1);

        board[row][col] = temp;
        node.refs -= found;
        if(node.refs == 0){
            prev.children[temp-'a']=null;
        }

        return found;
    }
}
