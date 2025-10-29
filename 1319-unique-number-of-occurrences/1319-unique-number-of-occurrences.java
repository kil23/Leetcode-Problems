class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> occurances = new HashSet<>();

        for(int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int count : map.values()) {
            if(occurances.contains(count)) return false;
            occurances.add(count);
        }

        return true;
    }
}