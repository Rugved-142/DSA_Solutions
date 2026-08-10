class Solution {
    List<List<String>> res = new ArrayList<>();
    List<String> cur = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0, 0);

        return res;
    }

    private void dfs(String s, int start, int end){
        if( end >= s.length()){
            if(start == end)
                res.add(new ArrayList<>(cur));
            return;
        }

        if(isPalindrome(s,start,end)){
            cur.add(s.substring(start,end+1));
            dfs(s,end+1,end+1);
            cur.remove(cur.size()-1);
        }
        
        dfs(s,start,end+1);
    }

    private boolean isPalindrome(String s, int l, int r){
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
