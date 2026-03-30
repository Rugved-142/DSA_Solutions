class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        HashMap<Character, Integer> s1=new HashMap<>();
        HashMap<Character, Integer> t1=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char x= s.charAt(i);
            s1.put(x,s1.getOrDefault(x,0)+1);
        }
        for(int i=0;i<t.length();i++){
            char x= t.charAt(i);
            t1.put(x,t1.getOrDefault(x,0)+1);
        }
        
        for(char x : s1.keySet()){
            if(!s1.get(x).equals(t1.get(x)))
                return false;
        }
    return true;
    }
}
