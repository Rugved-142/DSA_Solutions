class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> words = new HashSet<>(wordList);
        Queue<String> q = new LinkedList<>();

        q.add(beginWord);
        int count = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int j = 0;j<size;j++){
                String s = q.poll();
                if(s.equals(endWord)){
                        return count;
                }
                char[] chars = s.toCharArray();
                for(int i = 0; i<chars.length;i++){
                    char original = chars[i];
                    for(char c= 'a'; c <= 'z';c++){
                        if(c==original) continue;
                        chars[i] = c;
                        String newWord = new String(chars);
                        if(words.contains(newWord)){
                            q.add(newWord);
                            words.remove(newWord);
                        }
                    }
                    chars[i]=original;
                }
            }
            count++;
        }
    return 0;
    }
}
