class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
        for(int s : stones){
            q.add(s);
        }

        while(q.size()>1){
            int first = q.poll();
            int second = q.poll();

            if(first != second) q.add(Math.abs(first-second));
        }

        q.add(0);
        return q.peek();
    }
}
