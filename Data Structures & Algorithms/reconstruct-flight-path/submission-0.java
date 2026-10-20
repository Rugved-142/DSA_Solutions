class Solution {
    List<String> result = new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,List<String>> flights = new HashMap<>();

        for(List<String> ticket: tickets){
            String source = ticket.get(0);
            String dest = ticket.get(1);
            flights.computeIfAbsent(source,key -> 
            new ArrayList<>()).add(dest);
        }
        for(List<String> dests : flights.values()){
            Collections.sort(dests);
        }
        
        dfs("JFK",flights);
        Collections.reverse(result);
        return result;
    }
    private void dfs(String current, Map<String,List<String>> flights){
        if(!flights.containsKey(current)){
        result.add(current);
        return;
        }
        List<String> destinations = flights.get(current);
        while(destinations.size() > 0){
            String dest = destinations.get(0);
            destinations.remove(0);
            dfs(dest,flights);
        }
        result.add(current);
    }
}
