class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,List<Integer>> preMap = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            preMap.put(i,new ArrayList<>());
        }
        int[] indegree = new int[numCourses];

        for(int[] prereq : prerequisites){
            preMap.get(prereq[0]).add(prereq[1]);
            indegree[prereq[1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(indegree[i]==0) q.add(i);
        }

        int finish = 0;
        while(!q.isEmpty()){
            int node = q.poll();
            finish++;
            for(int nei : preMap.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0) q.add(nei);
            }
        }
        return finish == numCourses;
    }
}
