class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right) {
            int base = right - left;
            max = Math.max(max, base * Math.min(height[left], height[right]));
            if(height[left] <= height[right]) {
                left++;
            }else {
                right--;
            }
        }

        return max;
    }
}