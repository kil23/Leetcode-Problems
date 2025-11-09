class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        List<Integer> counts = new ArrayList<>(map.values());
        Collections.sort(counts, Collections.reverseOrder());

        int removed = 0;
        int size = 0;

        for(int count : counts) {
            removed += count;
            size++;
            if(removed >= arr.length / 2) {
                break;
            }
        }
        return size;
    }
}