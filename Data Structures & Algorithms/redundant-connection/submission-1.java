class Solution {
    class DSU {
        int[] parent;

        public DSU(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i; // Everyone starts as their own boss
            }
        }

        public int find(int x) {
            if (parent[x] == x) return x;
            return parent[x] = find(parent[x]); // Path compression
        }

        public boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);

            if (rootX == rootY) {
                return false; // Crucial moment: They already share a root! (Cycle detected)
            }
            
            parent[rootX] = rootY; // Otherwise, safely connect them
            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        // Nodes are 1-indexed up to edges.length
        DSU dsu = new DSU(edges.length + 1);

        for (int[] edge : edges) {
            // If union returns false, it means edge[0] and edge[1] were already connected
            if (!dsu.union(edge[0], edge[1])) {
                return edge; 
            }
        }

        return new int[0];
    }
}
