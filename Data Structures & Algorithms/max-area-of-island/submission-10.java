class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int count = island(grid, i, j);
                    if (count > max) {
                        max = count;
                    }
                }
            }
        }

        return max;
    }

    private int island(int[][] grid, int i, int j) {
        int count = 0;
        if (i < 0 || i == grid.length || j < 0 || j == grid[0].length || grid[i][j] == 0) {
            return 0;
        } else {
            grid[i][j] = 0;
            count += 1;
            count += island(grid, i + 1, j);
            count += island(grid, i - 1, j);
            count += island(grid, i, j + 1);
            count += island(grid, i, j - 1);
        }

        return count;
    }
}
