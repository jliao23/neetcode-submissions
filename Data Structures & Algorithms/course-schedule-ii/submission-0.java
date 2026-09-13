    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<Integer> output = new ArrayList<>();
            Map<Integer, List<Integer>> adjList = new HashMap<>();

            for (int i = 0; i < numCourses; i++) {
                adjList.put(i, new ArrayList<>());
            }

            for (int i = 0; i < prerequisites.length; i++) {
                int course = prerequisites[i][0];
                int req = prerequisites[i][1];

                adjList.get(course).add(req);
            }

            Set<Integer> visited = new HashSet<>();
            for (int i = 0; i < numCourses; i++) {
                Set<Integer> visiting = new HashSet<>();
                if (!dfs(i, visiting, visited, adjList, output)) {
                    int[] cycle = new int[0];
                    return cycle;
                }
            }

            int[] res = new int[numCourses];

            for (int i = 0; i < numCourses; i++) {
                res[i] = output.get(i);
            }

            return res;
        }

        public boolean dfs(int course, Set<Integer> visiting, Set<Integer> visited, Map<Integer, List<Integer>> adjList, List<Integer> output) {
            if (visiting.contains(course)) {
                return false;
            }

            if (visited.contains(course)) {
                return true;
            }

            visiting.add(course);

            List<Integer> reqs = adjList.get(course);
            for (int req : reqs) {
                if (!dfs(req, visiting, visited, adjList, output)) {
                    return false;
                }
            }

            visiting.remove(course);
            output.add(course);
            visited.add(course);

            return true;
        }
    }
