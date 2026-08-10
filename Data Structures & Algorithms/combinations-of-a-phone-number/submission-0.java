class Solution {

    List<String> res = new ArrayList<>();
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        backtrack(0,"",digits);

        return res;
    }

    private void backtrack(int i, String s, String digits){
        if(s.length()==digits.length()){
            res.add(s);
            return;
        }
        
        String chars = digitToChar[digits.charAt(i) - '0'];
        for(char c : chars.toCharArray()){
            backtrack(i+1, s + c,digits);
        }
    }
}
