class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int r=0; r<nums.length; r++) {
            if(map.containsKey(nums[r])) {
                int l = map.get(nums[r]);
                if(Math.abs(r -l) <= k) {
                    return true;
                }
            }
            map.put(nums[r], r);
        }

        return false;
    }
}