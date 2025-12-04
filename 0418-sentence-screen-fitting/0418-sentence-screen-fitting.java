class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {       
        String str = String.join(" ", sentence) + " ";
        int len = str.length();

        int pos = 0;
        for(int i=0; i<rows; i++) {
            pos += cols;

            if(str.charAt(pos % len) == ' ') {
                pos++;
            }else{
                while(pos>0 && str.charAt((pos - 1) % len) != ' '){
                    pos--;
                }
            }
        }

        return pos / len;
    }
}