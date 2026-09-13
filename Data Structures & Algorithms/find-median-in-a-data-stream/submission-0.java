class MedianFinder {
    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a,b) -> b - a);
    }
    
    public void addNum(int num) {
        if (minHeap.isEmpty() || num < minHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.add(minHeap.poll());
            } else {
                minHeap.add(maxHeap.poll());
            }
        }
    }
    
    public double findMedian() {
        if (minHeap.size() > maxHeap.size()) {
            return minHeap.peek();
        } else if (minHeap.size() < maxHeap.size()) {
            return maxHeap.peek();
        } else {
            double first = minHeap.peek();
            double second = maxHeap.peek();
            return ((first + second) / 2);
        }
    }
}
