class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // boolean found = false;
        // for(String s: wordList){
        //     if(s.equals(endWord)) found = true;
        // }
        // if(!found) return 0;

        Set<String> set = new HashSet<>(wordList);

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int steps = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j=0;j<size;j++){
                String word = q.poll();
                if(word.equals(endWord)) return steps;
                char[] chars = word.toCharArray();
                for(int i = 0; i < chars.length; i++){
                    char original = chars[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == original) continue;
                        chars[i] = c;
                        String candidate = new String(chars);
                        if(set.contains(candidate)){
                            set.remove(candidate);
                            q.add(candidate);
                        };
                    }
                    chars[i] = original;
                }
            }
            steps++;
        }
    return 0;
    }
}
