class Solution {
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = Integer.MIN_VALUE;

        for(int num : map.keySet()) {
            if(num == map.get(num)) {
                max = Math.max(max, num);
            }
        }

        if(max == Integer.MIN_VALUE) return -1;

        return max;
    }
}