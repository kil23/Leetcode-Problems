class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] opt = new int[n+1][m+1];

        for(int i=0; i<=n; i++) {
            opt[i][0] = i;
        }

        for(int i=0; i<=m; i++) {
            opt[0][i] = i;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    opt[i][j] = opt[i-1][j-1];
                }else{
                    opt[i][j] = Math.min(opt[i][j-1] + 1, Math.min(opt[i-1][j] + 1, opt[i-1][j-1] + 1));
                }
            }
        }

        return opt[n][m];
    }
}