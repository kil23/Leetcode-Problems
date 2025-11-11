class Solution {
    public int maxVowels(String s, int k) {
        int vowels = 0;

        for(int i=0; i<k; i++) {
            if(isVowel(s.charAt(i))) {
                vowels++;
            }
        }

        int max = vowels;

        for(int i=k; i<s.length(); i++) {
            if(isVowel(s.charAt(i))) {
                vowels++;
            }
            if(isVowel(s.charAt(i-k))) {
                vowels--;
            }
            max = Math.max(max, vowels);
        }

        return max;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}