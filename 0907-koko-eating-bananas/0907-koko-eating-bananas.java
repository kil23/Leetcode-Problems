class Solution {

    public boolean isPossible(int mid, int[] piles, int h) {
        int hours = 0;
        int n = piles.length;

        for(int pile: piles) {
            hours +=  (int) (Math.ceil((double)pile/mid));
        }

        return hours<=h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;
        int high = Integer.MAX_VALUE;

        int ans = -1;

        while(low<=high) {
            int mid = low + (high-low)/2;
            if(isPossible(mid, piles, h)) {
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;

    }
}