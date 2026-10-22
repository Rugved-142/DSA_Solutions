class Solution {
    public String foreignDictionary(String[] words) {
        Map<Character,Set<Character>> adj = new HashMap<>();
        Map<Character,Integer> indegree = new HashMap<>();

        for(String word : words){
            for(char c : word.toCharArray()){
                adj.putIfAbsent(c,new HashSet<>());
                indegree.putIfAbsent(c, 0);
            }
        }

        for(int i = 0; i < words.length - 1; i++){
            String word1 = words[i];
            String word2 = words[i+1];

            int minLen = Math.min(word1.length(),word2.length());
            if(word1.length() > word2.length() && word1.substring(0,minLen).equals(word2.substring(0,minLen))){
                return "";
            }

            for(int j = 0; j < minLen; j++){
                if(word1.charAt(j) == word2.charAt(j)) continue;
                if(!adj.get(word1.charAt(j)).contains(word2.charAt(j))) {
                    adj.get(word1.charAt(j)).add(word2.charAt(j));
                indegree.put(word2.charAt(j),indegree.get(word2.charAt(j))+1);
                }
                break;
            }
        }

        Queue<Character> q = new LinkedList<>();

        for(char c : indegree.keySet()){
            if(indegree.get(c) == 0) q.offer(c);
        }

        StringBuilder res = new StringBuilder();

        while(!q.isEmpty()){
            Character c = q.poll();
            res.append(c);
            for(char neighbor : adj.get(c)){
                indegree.put(neighbor,indegree.get(neighbor)-1);
                if(indegree.get(neighbor) == 0) q.offer(neighbor);
            }
        }
    return res.length() != indegree.size() ? "" : res.toString();
    }
}
