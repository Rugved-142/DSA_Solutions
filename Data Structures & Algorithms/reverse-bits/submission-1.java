class Solution {
    public int reverseBits(int n) {
        int res = 0;
        for(int i=0;i<32;i++){
            if(((1 << i) & n) != 0) res = res | (1<< (31 - i));
        }
        return res;
    }
}
