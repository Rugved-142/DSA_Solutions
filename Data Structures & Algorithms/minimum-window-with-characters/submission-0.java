class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";

        Map<Character, Integer> t_freq=new HashMap<>();
        for(int i=0;i<t.length();i++){
            t_freq.put(t.charAt(i),t_freq.getOrDefault(t.charAt(i),0)+1);
        }

        for(int size = t.length(); size<= s.length(); size++){
            Map<Character, Integer> s_freq = new HashMap<>();
            int left=0;
            int right=0;

            while(right<s.length()){
                char rightChar = s.charAt(right);
                s_freq.put(rightChar, s_freq.getOrDefault(rightChar, 0) + 1);
                if(right-left + 1 ==size){
                    boolean isValid = true;
                    for (char x : t_freq.keySet()) {
                        if (s_freq.getOrDefault(x, 0) < t_freq.get(x)) {
                            isValid = false;
                            break;
                        }
                    }
                    if (isValid) return s.substring(left, right + 1);

                    char leftChar = s.charAt(left);
                    s_freq.put(leftChar, s_freq.get(leftChar) - 1);
                    left++;
                }
                right++;
            }
        }
        return "";
    }
}
