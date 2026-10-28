class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for (int[] time : times) {
            if (adjList.containsKey(time[0])) {
                adjList.get(time[0]).add(new int[]{time[1], time[2]});
            } else {
                List<int[]> temp = new ArrayList<>();
                temp.add(new int[]{time[1], time[2]});
                adjList.put(time[0], temp);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.offer(new int[]{0, k});
        Set<Integer> visited = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int total = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (visited.contains(curr[1])) {
                continue;
            }

            visited.add(curr[1]);
            total = curr[0];
            List<int[]> neighbors = adjList.getOrDefault(curr[1], new ArrayList<>());

            for (int[] neighbor : neighbors) {
                if (visited.contains(neighbor[0])) {
                    continue;
                }

                total = neighbor[1] + curr[0];
                pq.offer(new int[]{total, neighbor[0]});
            }

            if (visited.size() == n && total < min) {
                min = total;
            }
        }

        if (visited.size() != n) {
            return -1;
        }
        return min;
    }
}
