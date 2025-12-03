class Solution {
    public int longestPalindrome(String s) {
        Set<Character> unpairedChar = new HashSet<>();

        for(char c : s.toCharArray()) {
            if(unpairedChar.contains(c)) {
                unpairedChar.remove(c);
            }else{
                unpairedChar.add(c);
            }
        }

        int len = s.length();
        int unpairLen = unpairedChar.size();

        if(unpairLen > 0) {
            return len - unpairLen + 1;
        }
        else {
            return len;
        }
    }
}