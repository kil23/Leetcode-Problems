class Solution {
    public boolean backspaceCompare(String s, String t) {
        return buildStack(s).equals(buildStack(t));
    }

    private Stack<Character> buildStack(String str) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '#') {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
            }else{
                stack.push(ch);
            }
        }

        return stack;
    }
}