class Solution {
    Map<Integer,List<Integer>> preMap = new HashMap<>();
    Set<Integer> visiting = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        for(int i=0;i<numCourses;i++){
            preMap.put(i,new ArrayList<>());
        }
        for(int[] pre : prerequisites){
            preMap.get(pre[0]).add(pre[1]);
        }

        for(int crs = 0; crs < numCourses; crs++){
            if(!dfs(crs)) return false;
        }

    return true;
    }

    private boolean dfs(int crs){
        if(visiting.contains(crs)) return false;

        if(preMap.get(crs).isEmpty()) return true;

        visiting.add(crs);
        for(int pre : preMap.get(crs)){
            if(!dfs(pre)) return false;
        }
        visiting.remove(crs);
        preMap.put(crs,new ArrayList<>());

        return true;
    }
}
