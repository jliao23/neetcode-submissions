class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int freshOranges = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }

                if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        int minutes = 0;

        while (!q.isEmpty() && freshOranges > 0) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] pos = q.poll();
                int x = pos[0];
                int y = pos[1];

                if (x > 0 && grid[x - 1][y] == 1) {
                    grid[x - 1][y] = 2;
                    q.offer(new int[]{x - 1, y});
                    freshOranges--;
                }

                if (x < grid.length - 1 && grid[x + 1][y] == 1) {
                    grid[x + 1][y] = 2;
                    q.offer(new int[]{x + 1,y});
                    freshOranges--;
                }

                if (y > 0 && grid[x][y - 1] == 1) {
                    grid[x][y - 1] = 2;
                    q.offer(new int[]{x, y - 1});
                    freshOranges--;
                }

                if (y < grid[0].length - 1 && grid[x][y + 1] == 1) {
                    grid[x][y + 1] = 2;
                    q.offer(new int[]{x, y + 1});
                    freshOranges--;
                }
            }

            minutes++;
            System.out.println(Arrays.deepToString(grid));
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return minutes;
    }
}
