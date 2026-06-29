class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        int[][] cars = new int[position.length][2];
        for(int i=0;i<position.length;i++){
            cars[i][0]=position[i];
            cars[i][1]=speed[i];
        }
        Arrays.sort(cars,(a,b) -> b[0] - a[0]);

        for(int i=0 ; i < position.length; i++){
            double time = (double)(target - cars[i][0]) / cars[i][1];
            if(stack.isEmpty() || time > (double)stack.peek()){
                stack.push(time);
            }
            
        }
        return stack.size();
    }
}
