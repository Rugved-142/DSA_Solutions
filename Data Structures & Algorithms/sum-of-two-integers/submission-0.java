class Solution {
    public int getSum(int a, int b) {
       int carry =0;
       int res = 0;

       for(int i=0;i<32;i++){
        int a_bit = (a >> i) & 1;
        int b_bit = (b >> i) & 1;
        int curr_bit = (a_bit ^ b_bit ^ carry);
        carry = (a_bit & b_bit) | (b_bit & carry) | (a_bit & carry);

        if(curr_bit !=0)
            res |= (1 << i);
       } 
       return res;
    }
}
