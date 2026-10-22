class Solution {
    List<String> path = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> flights = new HashMap<>();
        for(List<String> ticket: tickets){
            String source = ticket.get(0);
            String dest = ticket.get(1);
            flights.computeIfAbsent(source, key -> new ArrayList<>()).add(dest);
        }
        for(List<String> dests : flights.values()){
            Collections.sort(dests);
        }

        dfs("JFK",flights);
        Collections.reverse(path);
        return path;
    }

    private void dfs(String source,Map<String,List<String>> flights){
        if(!flights.containsKey(source)){
            path.add(source);
            return;
        }
        List<String> dests = flights.get(source);
        while(dests.size() >0){
            String newSource = dests.get(0);
            dests.remove(newSource);
            dfs(newSource,flights);
        }
        path.add(source);
    }
}
