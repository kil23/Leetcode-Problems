class Solution {
    public String reverseOnlyLetters(String s) {
        int left = 0;
        int right = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);
        while(left < right) {
            if(!Character.isLetter(sb.charAt(left))) {
                left++;
            } else if(!Character.isLetter(sb.charAt(right))) {
                right--;
            } else {
                char temp = sb.charAt(left);
                sb.setCharAt(left, sb.charAt(right));
                sb.setCharAt(right, temp);
                left++;
                right--;
            }
        }

        return new String(sb);
    }
}