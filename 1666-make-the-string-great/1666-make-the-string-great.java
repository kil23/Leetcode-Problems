class Solution {
    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(sb.length() == 0) {
                sb.append(ch);
            }else{
                char top = sb.charAt(sb.length() - 1);
                if((Character.isLowerCase(top) && Character.isUpperCase(ch) || 
                Character.isUpperCase(top) && Character.isLowerCase(ch)) && 
                Character.toUpperCase(top) == Character.toUpperCase(ch)) {
                    sb.deleteCharAt(sb.length() - 1); 
                }else {
                    sb.append(ch);
                }
            }
        }

        return new String(sb);
    }
}