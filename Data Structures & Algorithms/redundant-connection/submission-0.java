class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= edges.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            boolean[] visit = new boolean[edges.length + 1];
            if (isCycle(edge[0], -1, adj, visit)) {
                return edge;
            }
        }

        return new int[1];
    }

    private boolean isCycle(int node, int parent, List<List<Integer>> adj, boolean[] visit) {
        if (visit[node]) {
            return true;
        }

        visit[node] = true;
        for (int neighbor : adj.get(node)) {
            if (neighbor == parent) {
                continue;
            } else {
                if (isCycle(neighbor, node, adj, visit)) {
                    return true;
                }
            }
        }

        return false;
    }
}
