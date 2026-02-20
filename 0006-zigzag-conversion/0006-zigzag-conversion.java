class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        StringBuilder[] rows = new StringBuilder[numRows];
        for(int row=0; row<numRows; row++){
            rows[row] = new StringBuilder();
        }

        int currRow = 0;
        int dir = -1;

        for(char ch : s.toCharArray()) {
            rows[currRow].append(ch);

            if(currRow == 0 || currRow == numRows - 1){
                dir = -dir;
            }

            currRow += dir;
        }

        StringBuilder res = new StringBuilder();
        for(StringBuilder row : rows) {
            res.append(row);
        }

        return res.toString();
    }
}