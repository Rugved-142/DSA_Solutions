class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n+1];
        cache[n] = 1;
        cache[n-1] = 1;
        for(int i = n-2; i>=0;i--){
            cache[i] = cache[i+1] + cache[i+2];
        }
    return cache[0];
    }
}
