class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> preMap = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            preMap.put(i,new ArrayList<>());
        }
        int[] indegree = new int[numCourses];

        for(int[] prereq : prerequisites){
            preMap.get(prereq[1]).add(prereq[0]);
            indegree[prereq[0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i]==0) q.add(i);
        }

        int finish = 0;
        int[] res = new int[numCourses];
        while(!q.isEmpty()){
            int node = q.poll();
            res[finish] = node;
            finish++;
            for(int nei : preMap.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0) q.add(nei);
            }
        }
        return finish == numCourses? res : new int[0];
    }
}
