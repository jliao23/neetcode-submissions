class MinStack {

    private Stack<Integer> stack;
    private Stack<Integer> helper;
    private int min;

    public MinStack() {
        stack = new Stack<>();
        helper = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        stack.push(val);
        if (helper.isEmpty() || val <= min) {
            helper.push(val);
            min = val;
        }
    }

    public void pop() {
        int curr = stack.pop();
        if (min == curr) {
            helper.pop();
            if (!helper.isEmpty()) {
                min = helper.peek();
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}