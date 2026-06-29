class MinStack {
    int[] stack;
    int top;
    int[] minStack;

    public MinStack() {
        stack = new int[30000];
        top = -1;
        minStack = new int[30000];
    }
    
    public void push(int val) {
        if(top == -1){
            stack[++top] = val;
            minStack[top] = val;
        }else{
            stack[++top] = val;
            if(val < minStack[top-1]){
                minStack[top] = val;
            }else{
                minStack[top]=minStack[top-1];
            }
        }
    }
    
    public void pop() {
        if(top >= 0){
            top --;
        }
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        return minStack[top];
    }
}
