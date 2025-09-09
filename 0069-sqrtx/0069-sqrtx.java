class Solution {
    public int mySqrt(int x) {
        if(x < 2) return x;
        int l = 0;
        int h = x;

        int res = -1;

        while(l<=h) {
            int mid = l + (h-l)/2;

            if(mid == x/mid) {
                return mid;
            }else if(mid > x/mid) {
                h = mid - 1;
                res = mid;
            }else {
                l = mid + 1;
            }
        }

        return res - 1;
    }
}