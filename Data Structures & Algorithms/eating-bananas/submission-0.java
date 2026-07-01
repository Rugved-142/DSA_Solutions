class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        int res = right;
        for(int pile : piles){
            right = Math.max(right,pile);
        }

        while(left <= right){
            int k = (left+right)/2;

            long totalTime = 0;
            for(int pile : piles){
                totalTime += Math.ceil((double)pile/k);
            }
            if(totalTime <= h){
                res = k;
                right = k-1;
            }else{
                left = k+1;
            }
        }
        return res;
    }
}
