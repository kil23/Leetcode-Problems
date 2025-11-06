class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for(int asteriod : asteroids) {
            while(!stack.isEmpty() && stack.peek() > 0 && asteriod < 0) {
                if(stack.peek() > -asteriod) {
                    asteriod = 0;
                    break;
                } else if(stack.peek() == -asteriod) {
                    stack.pop();
                    asteriod = 0;
                } else {
                    stack.pop();
                }
            }

            if(asteriod != 0) {
                stack.push(asteriod);
            }
        }

        int[] result = new int[stack.size()];
        for(int i=result.length - 1; i>=0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}