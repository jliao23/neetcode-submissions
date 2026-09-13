class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // key: 0 value: 1
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        // build adj list
        for (int i = 0; i < prerequisites.length; i++) {
            int key = prerequisites[i][0];
            int value = prerequisites[i][1];

            if (adjList.containsKey(key)) {
                adjList.get(key).add(value);
            } else {
                List<Integer> courses = new ArrayList<>();
                courses.add(value);
                adjList.put(key, courses);
            }
        }

        // run dfs
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            Set<Integer> visiting = new HashSet<>();
            if (dfs(adjList, visiting, visited, i) == false) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(Map<Integer, List<Integer>> adjList, Set<Integer> visiting, Set<Integer> visited, int key) {
        if (visited.contains(key)) {
            return true;
        }
        if (visiting.contains(key)) {
            return false;
        } else if (!adjList.containsKey(key)) {
            return true;
        } else {
            visiting.add(key);
            for (int k : adjList.get(key)) {
                if (dfs(adjList, visiting, visited, k) == false) {
                    return false;
                }
            }
            visiting.remove(key);
            visited.add(key);
        }

        return true;
    }
}

