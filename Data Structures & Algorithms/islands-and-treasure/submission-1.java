class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();

        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    q.add(new int[]{i, j});
                }
            }
        }

        int layer = 1;
        while (!q.isEmpty()) {
            int size = q.size(); 
            for (int i = 0; i < size; i++) {
                int[] pos = q.poll();
                int x = pos[0];
                int y = pos[1];

                if (x > 0 && grid[x - 1][y] == 2147483647) {
                    grid[x - 1][y] = layer;
                    q.add(new int[]{x - 1, y});
                }

                if (x < grid.length - 1 && grid[x + 1][y] == 2147483647) {
                    grid[x + 1][y] = layer;
                    q.add(new int[]{x + 1, y});
                }

                if (y > 0 && grid[x][y - 1] == 2147483647) {
                    grid[x][y - 1] = layer;
                    q.add(new int[]{x, y - 1});
                }

                if (y < grid[0].length - 1 && grid[x][y + 1] == 2147483647) {
                    grid[x][y + 1] = layer;
                    q.add(new int[]{x, y + 1});
                }
            }

            layer++;
        }
    }
}
