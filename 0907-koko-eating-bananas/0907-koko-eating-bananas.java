class Solution {
     public boolean isPossible(int mid, int[] piles, int h) {
        long countHr = 0;
        for(int pile: piles) {
            countHr += (int)Math.ceil((double)pile/mid);
        }
        System.out.println(countHr);
        return h >= countHr;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        int ans = -1;

        while(low<=high) {
            int mid = low + (high - low)/2;
            if(isPossible(mid, piles, h)) {
                ans = mid;
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return ans;
    }
}