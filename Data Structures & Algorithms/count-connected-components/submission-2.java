class Solution {
    Set<Integer> visited = new HashSet<>();
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int[] edge : edges) {
            if (adjList.containsKey(edge[0])) {
                adjList.get(edge[0]).add(edge[1]);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(edge[1]);
                adjList.put(edge[0], temp);
            }

            if (adjList.containsKey(edge[1])) {
                adjList.get(edge[1]).add(edge[0]);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(edge[0]);
                adjList.put(edge[1], temp);
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                dfs(adjList, i);
                count++;
            }
        }

        return count;
    }

    private void dfs(Map<Integer, List<Integer>> adjList, int curr) {
        visited.add(curr);
        List<Integer> neighbors = adjList.get(curr);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    dfs(adjList, neighbor);
                }
            }
        }
    }
}
