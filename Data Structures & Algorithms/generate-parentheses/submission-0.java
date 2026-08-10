class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("",res,n);

        return res;
    }

    private void dfs(String s, List<String> res, int n){
        if( 2*n == s.length()){
            if( valid(s))
                res.add(s);
            return;
        }

        dfs(s+'(',res,n);
        dfs(s+')',res,n);
    }

    private boolean valid(String s){
        int balance = 0;
        for( char c: s.toCharArray()){
            balance += c=='(' ? 1:-1;
            if(balance < 0) return false;
        }
        return balance ==0;
    }
}
