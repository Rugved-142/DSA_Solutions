class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxf = 0;
        int res = 0;
        HashMap<Character,Integer> count = new HashMap<>();

        for(int right=0;right<s.length();right++){
            char c = s.charAt(right);
            count.put(c , count.getOrDefault(c,0)+1);
            maxf = Math.max(maxf,count.get(c));
            while((right-left+1) - maxf > k){
                char leftChar = s.charAt(left);
                count.put(leftChar,count.get(leftChar)-1);
                left++;
            }
            res = Math.max(res, (right-left+1));
        } 
    return res;
    }
}
