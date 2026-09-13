class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> edge = new ArrayList<>();
            adj.add(edge);
        }

        for (int[] edge : edges) {
            int first = edge[0];
            int second = edge[1];

            adj.get(first).add(second);
            adj.get(second).add(first);
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.add(0);
        int count = 1;
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        while (!q.isEmpty()) {
            int node = q.poll();
            List<Integer> neighbors = adj.get(node);
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    q.add(neighbor);
                    count++;
                }
            }
        }

        if (count == n) {
            return true;
        }

        return false;
    }
}
