class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        Map<Character, Integer> t_freq=new HashMap<>();
        for(int i=0;i<t.length();i++){
            t_freq.put(t.charAt(i),t_freq.getOrDefault(t.charAt(i),0)+1);
        }
        Map<Character, Integer> s_freq = new HashMap<>();
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int startNode=0;

        int have =0;
        int need = t_freq.size();

        for(int j=0;j<s.length();j++){
            char c = s.charAt(j);
            s_freq.put(c, s_freq.getOrDefault(c, 0) + 1);

            if(t_freq.containsKey(c) && s_freq.get(c).equals(t_freq.get(c))){
                have ++;
            }
            while(have == need){
                if(j-left+1 < minLen){
                    minLen = j-left+1;
                    startNode = left;
                }
                char leftChar = s.charAt(left);
                s_freq.put(leftChar, s_freq.get(leftChar) - 1);

                if (t_freq.containsKey(leftChar) && s_freq.get(leftChar) < t_freq.get(leftChar)) {
                    have--;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(startNode, startNode + minLen);



        // for(int size = t.length(); size<= s.length(); size++){
            
        //     int left=0;
        //     int right=0;

        //     while(right<s.length()){
        //         char rightChar = s.charAt(right);
        //         s_freq.put(rightChar, s_freq.getOrDefault(rightChar, 0) + 1);
        //         if(right-left + 1 ==size){
        //             boolean isValid = true;
        //             for (char x : t_freq.keySet()) {
        //                 if (s_freq.getOrDefault(x, 0) < t_freq.get(x)) {
        //                     isValid = false;
        //                     break;
        //                 }
        //             }
        //             if (isValid) return s.substring(left, right + 1);

        //             char leftChar = s.charAt(left);
        //             s_freq.put(leftChar, s_freq.get(leftChar) - 1);
        //             left++;
        //         }
        //         right++;
        //     }
        // }
        // return "";
    }
}
