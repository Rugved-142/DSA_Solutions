class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        HashMap<Character, Integer> freqT = new HashMap<>();
        HashMap<Character, Integer> freqS = new HashMap<>();      
        for(char c : t.toCharArray()) freqT.put(c, freqT.getOrDefault(c,0)+1);

        int left = 0;
        int startNode = 0;
        int minLen = Integer.MAX_VALUE;

        int have = 0;
        int need = freqT.size();
        
        for(int right=0;right<s.length();right++)
        {
            char c = s.charAt(right);
            freqS.put(c, freqS.getOrDefault(c,0)+1);

            if(freqT.containsKey(c) && freqS.get(c).equals(freqT.get(c))) have++;

            while(have == need){
                if(right-left+1 < minLen){
                    minLen = right - left + 1;
                    startNode = left;
                }

                char leftChar = s.charAt(left);
                freqS.put(leftChar, freqS.get(leftChar) - 1);

                if (freqT.containsKey(leftChar) && freqS.get(leftChar) < freqT.get(leftChar)) {
                    have--;
                }

                left++;
            }     
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(startNode, startNode + minLen);
    }
}
