class Solution {
    public int minimumCardPickup(int[] cards) {
        int minLen = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<cards.length; i++) {
            if(!map.containsKey(cards[i])) {
                map.put(cards[i], i);
            } else {
                minLen = Math.min(minLen, i - map.get(cards[i]) + 1);
                map.put(cards[i], i);
            }
        }

        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}