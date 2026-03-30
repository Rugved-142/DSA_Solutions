class Solution {
    public int lengthOfLongestSubstring(String s) {
        Deque<Character> deque =new LinkedList<>();
        //Set<Character> set = new HashSet<>();
        int max = 0;
        for(int i=0;i<s.length();i++){
            if(deque.contains(s.charAt(i))){
                while(deque.removeFirst() != s.charAt(i));
            }
            deque.add(s.charAt(i));
            max=Math.max(max,deque.size());
        }
        return max;
    }
}
