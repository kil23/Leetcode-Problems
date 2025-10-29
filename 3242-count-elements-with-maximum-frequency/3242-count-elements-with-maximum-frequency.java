class Solution {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = 0;
        int freq = 0;
        for(int count : map.values()) {
            if(count>max) {
                max = count;
            }
        }

        for(int num: map.keySet()) {
            if(map.get(num) == max) {
                freq += max;
            }
        }

        return freq;
    }
}