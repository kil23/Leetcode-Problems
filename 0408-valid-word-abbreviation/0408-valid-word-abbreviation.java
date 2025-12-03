class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int len = word.length();
        int len2 = abbr.length();

        int i=0; 
        int j=0;
        
        while(i < len && j < len2) {
            char abbrChar = abbr.charAt(j);

            if(Character.isLetter(abbrChar)) {
                if(word.charAt(i) != abbrChar) return false;
                i++;
                j++;
            }
            else if(Character.isDigit(abbrChar)) {
                if(abbrChar == '0') {
                    return false;
                }

                int num = 0;
                while(j < len2 && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + Character.getNumericValue(abbr.charAt(j));
                    j++;
                }

                i += num;
            }
        }

        return i == len && j == len2;
    }
}