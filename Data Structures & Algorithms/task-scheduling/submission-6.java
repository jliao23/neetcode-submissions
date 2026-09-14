class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> frequencies = new HashMap<>();
        for (char task : tasks) {
            frequencies.put(task, frequencies.getOrDefault(task, 0) + 1);
        }

        // Max-heap sorting by frequency descending
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> frequencies.get(b) - frequencies.get(a));
        for (Character key : frequencies.keySet()) {
            maxHeap.add(key);
        }

        List<Character> sequence = new ArrayList<>();

        while (!maxHeap.isEmpty()) {
            int cycleCount = n + 1;
            // Use a temporary list to hold tasks processed during THIS cycle
            List<Character> temp = new ArrayList<>();

            // Only pull tasks if the heap has elements AND we still have slots left in this cycle
            while (maxHeap.size() > 0 && cycleCount > 0) {
                char curr = maxHeap.poll();
                sequence.add(curr);
                
                frequencies.put(curr, frequencies.get(curr) - 1);
                // If it still needs to be run in future cycles, save it for later
                if (frequencies.get(curr) > 0) {
                    temp.add(curr);
                }
                
                cycleCount--;
            }

            // Put the surviving tasks back into the maxHeap for the NEXT cycle
            for (char task : temp) {
                maxHeap.add(task);
            }

            // If the heap isn't empty, it means we have more cycles to go.
            // Fill any remaining cycle slots with idle time ('0')
            if (!maxHeap.isEmpty()) {
                for (int i = 0; i < cycleCount; i++) {
                    sequence.add('0');
                }
            }
        }

        return sequence.size();
    }
}
