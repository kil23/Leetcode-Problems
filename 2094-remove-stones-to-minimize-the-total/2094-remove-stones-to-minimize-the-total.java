class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
        for(int pile : piles) {
            heap.add(pile);
        }

        while(k > 0) {
            int top = heap.remove();
            heap.add(top - (top/2));
            k--;
        }

        int total = 0;
        while(!heap.isEmpty()) {
            total += heap.remove();
        }

        return total;
    }
}