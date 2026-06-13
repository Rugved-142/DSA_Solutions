class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        char[] arr = new char[26];

        for( char c : s.toCharArray()){
            arr[c - 'a']++;
        }

        for(char c : t.toCharArray()){
            if(arr[c-'a'] == 0)
                return false;
            arr[c-'a']--;
        }
        return true;
    }
}
