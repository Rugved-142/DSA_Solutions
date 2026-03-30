class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        for(int i=0;i<s.length();i++){
            List<Character> list = new ArrayList<>();
            for(int j=i;j<s.length();j++){
                if(!list.contains(s.charAt(j))){
                    list.add(s.charAt(j));
                    max=Math.max(max,list.size());
                }else break;
            }
        }
        return max;
    }
}
