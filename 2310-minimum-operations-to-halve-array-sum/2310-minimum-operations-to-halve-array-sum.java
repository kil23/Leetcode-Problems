class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> heap = new PriorityQueue<>(Comparator.reverseOrder());
        double sum = 0;
        for(double num : nums) {
            sum += num;
            heap.add(num);
        }

        double half = sum / 2;
        int opr = 0;

        while(sum>half) {
            double top = heap.remove();
            sum -= top / 2;
            opr++;
            heap.add(top/2);
        }

        return opr;
    } 
}