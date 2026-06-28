class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        HashMap<Character,Integer> freq1 = new HashMap<>();
        HashMap<Character,Integer> freq2 = new HashMap<>();

        for(char c : s1.toCharArray()){
            freq1.put(c,freq1.getOrDefault(c,0)+1);
        }
        int left =0;
        int right = 0;
        while(right < s1.length()){
            char c = s2.charAt(right);
            freq2.put(c,freq2.getOrDefault(c,0)+1);
            right++;
        }
        while(right < s2.length()){
            if(freq1.equals(freq2)) return true;
            
            char l = s2.charAt(left);
            freq2.put(l, freq2.get(l) - 1);
            if (freq2.get(l) == 0) freq2.remove(l);
            left++;

            char r = s2.charAt(right);
            freq2.put(r, freq2.getOrDefault(r, 0) + 1);
            right++;
        }
        return freq1.equals(freq2);
    }
}
