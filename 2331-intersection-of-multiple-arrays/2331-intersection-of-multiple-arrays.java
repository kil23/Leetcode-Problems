class Solution {
    public List<Integer> intersection(int[][] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int[] numArr : nums) {
            for(int num : numArr) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int key : map.keySet()) {
            if(map.get(key) == nums.length) {
                list.add(key);
            }
        }
        Collections.sort(list);
        return list;
    }
}