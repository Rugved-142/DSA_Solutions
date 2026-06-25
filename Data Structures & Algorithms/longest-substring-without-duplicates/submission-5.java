class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> res = new HashSet<>();
        int left = 0;
        int size = 0;
        for( char c : s.toCharArray()){
            while(res.contains(c)){
                res.remove(s.charAt(left));
                left++;
            }
            res.add(c);
            size = Math.max(size, res.size());
        }

        return size;
    }
}
