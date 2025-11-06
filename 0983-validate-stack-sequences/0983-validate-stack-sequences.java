class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int pop = 0;

        for(int push = 0; push < pushed.length; push++) {
            stack.push(pushed[push]);
            while(!stack.isEmpty() && pop < popped.length && stack.peek() == popped[pop]) {
                stack.pop();
                pop++;
            }
        }

        return pop == popped.length;
    }
}