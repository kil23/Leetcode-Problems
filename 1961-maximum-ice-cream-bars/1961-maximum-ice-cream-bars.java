class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int spent = 0;
        int bars = 0;

        for(int cost : costs) {
            if(spent + cost <= coins) {
                spent += cost;
                bars++;
            }
        }

        return bars;
    }
}