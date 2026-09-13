class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : stones) {
            maxHeap.add(num);
        }

        while (maxHeap.size() > 1) {
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            if (stone1 - stone2 > 0) {
                maxHeap.add(stone1 - stone2);
            }
        }

        if (maxHeap.size() > 0) {
            return maxHeap.poll();
        }

        return 0;
    }
}
