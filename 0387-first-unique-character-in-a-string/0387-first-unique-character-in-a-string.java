class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> result = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            result.put(ch, result.getOrDefault(ch, 0) + 1);
        }

        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if(result.get(ch) == 1) return i;
        }
        
        return -1;
    }
}