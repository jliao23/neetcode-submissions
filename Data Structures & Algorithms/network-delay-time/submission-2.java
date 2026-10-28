
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for (int[] time : times) {
            adjList.computeIfAbsent(time[0], x -> new ArrayList<>())
                   .add(new int[]{time[1], time[2]});
        }

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[]{0, k});
        Set<Integer> visited = new HashSet<>();
        int maxTime = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0];
            int node = curr[1];

            if (visited.contains(node)) continue;

            visited.add(node);

            // Record the arrival time of this finalized node.
            maxTime = Math.max(maxTime, time);

            for (int[] neighbor : adjList.getOrDefault(
                    node, new ArrayList<>())) {
                if (!visited.contains(neighbor[0])) {
                    pq.offer(new int[]{time + neighbor[1], neighbor[0]});
                }
            }
        }

        return visited.size() == n ? maxTime : -1;
    }
}
