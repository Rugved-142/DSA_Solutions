class Twitter {

    int count;
    Map<Integer, List<int[]>> tweetMap;
    Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        count = 0;
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        tweetMap.putIfAbsent(userId, new ArrayList<>());
        tweetMap.get(userId).add(new int[]{count++,tweetId});  
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<int[]> feed = new ArrayList<>
        (tweetMap.getOrDefault(userId, new ArrayList<>()));
         for(int followeeId : followMap.getOrDefault(userId,new HashSet<>())){
            feed.addAll(tweetMap.getOrDefault(followeeId,new ArrayList<>()));
        }
        feed.sort((a,b) -> b[0] - a[0]);

        List<Integer> res = new ArrayList<>();

        int feedCnt = Math.min(10,feed.size());
        for(int i=0;i<feedCnt ; i++){
            res.add(feed.get(i)[1]);
        }
        return res;
    }
    
    public void follow(int followerId, int followeeId) {
        if(followerId != followeeId){
            followMap.putIfAbsent(followerId,new HashSet<>());
            followMap.get(followerId).add(followeeId);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        followMap.getOrDefault(followerId, new HashSet<>()).remove(followeeId);
    }
}
