class Solution {
    public int maxNumberOfApples(int[] weight) {
        Arrays.sort(weight);
        int units = 0;
        int totalCount = 0;

        for(int i=0; i<weight.length; i++) {
            if(units + weight[i] <= 5000) {
                units += weight[i];
                totalCount++;
            }
        }

        return totalCount;
    }
}