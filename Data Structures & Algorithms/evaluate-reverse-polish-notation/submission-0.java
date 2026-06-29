class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<tokens.length;i++){
            String s = tokens[i];
            int a;
            int b;
            if(s.equals("+")){
                b=st.pop();
                a=st.pop();
                st.push(a+b);
            }
            else if(s.equals("-")){
                b=st.pop();
                a=st.pop();
                st.push(a-b);
            }else if(s.equals("*")){
                b=st.pop();
                a=st.pop();
                st.push(a*b);
            }else if(s.equals("/")){
                b=st.pop();
                a=st.pop();
                st.push(a/b);
            }else{
                st.push(Integer.valueOf(s));
            }
        }
        return st.pop();
    }
}
