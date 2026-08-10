class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        backtrack(0,0,res,n,s);

        return res;
    }

    private void backtrack(int open, int close, List<String> res, int n, StringBuilder s){
        if(open == close && open == n){
            res.add(s.toString());
            return;
        }
        if(open < n){
            s.append('(');
            backtrack(open+1,close,res,n,s);
            s.deleteCharAt(s.length()-1);
        }

        if(close < open){
            s.append(')');
            backtrack(open,close+1,res,n,s);
            s.deleteCharAt(s.length()-1);
        }
    }
}
