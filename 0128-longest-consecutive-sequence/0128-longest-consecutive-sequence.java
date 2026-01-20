class Solution {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();
        int longestLen = 0;
        for(int num : nums) {
            set.add(num);
        }

        for(int num : set) {
            if(!set.contains(num - 1)) {
                int currentLen = 1;

                while(set.contains(num + 1)) {
                    num++;
                    currentLen++;
                }

                longestLen = Math.max(longestLen, currentLen);
            }
        }

        return longestLen;
    }
}