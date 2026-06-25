class Solution {
    public int lengthOfLongestSubstring(String s) {
        Queue<Character> res = new LinkedList<>();
        int size = 0;
        for( char c : s.toCharArray()){
            if(res.contains(c)){
                while(res.poll()!= c){
                }
            }
            res.add(c);
            size = Math.max(size, res.size());
        }

        return size;
    }
}
