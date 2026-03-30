class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map = new HashMap<>();

        for(String s: strs){
            String deliminator = getFreq(s);
            if(map.containsKey(deliminator))
                map.get(deliminator).add(s);
            else{
                map.put(deliminator, new ArrayList<>(Arrays.asList(s)));
            }
        }


        return new ArrayList<>( map.values() );
    }
    private String getFreq(String s){
        int[] freq = new int[26];
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i) -'a']++; 
        }
        StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 26; i++) {
        if (freq[i] > 0) {  
            char c = (char)(i + 'a');
            sb.append(c);
            sb.append(freq[i]);
            sb.append('#');
        }
    }

    return sb.toString();
    }
}
