class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();

        for (int i = 0; i < heights[0].length; i++) {
            q1.add(new int[]{0, i});
            pacific[0][i] = true;
        }

        for (int i = 1; i < heights.length; i++) {
            q1.add(new int[]{i, 0});
            pacific[i][0] = true;
        }

        for (int i = 0; i < heights[0].length; i++) {
            q2.add(new int[]{heights.length - 1, i});
            atlantic[heights.length - 1][i] = true;
        }

        for (int i = 0; i < heights.length; i++) {
            q2.add(new int[]{i, heights[0].length - 1});
            atlantic[i][heights[0].length - 1] = true;
        }

        while (!q1.isEmpty()) {
            int[] curr = q1.poll();
            int x = curr[0];
            int y = curr[1];

            if (x > 0 && heights[x - 1][y] >= heights[x][y]) {
                if (!pacific[x - 1][y]) {
                    q1.add(new int[]{x - 1, y});
                    pacific[x - 1][y] = true;
                }
            }

            if (x < heights.length - 1 && heights[x + 1][y] >= heights[x][y]) {
                if (!pacific[x + 1][y]) {
                    q1.add(new int[]{x + 1, y});
                    pacific[x + 1][y] = true;
                }
            }

            if (y > 0 && heights[x][y - 1] >= heights[x][y]) {
                if (!pacific[x][y - 1]) {
                    q1.add(new int[]{x, y - 1});
                    pacific[x][y - 1] = true;
                }
            }

            if (y < heights[0].length - 1 && heights[x][y + 1] >= heights[x][y]) {
                if (!pacific[x][y + 1]) {
                    q1.add(new int[]{x, y + 1});
                    pacific[x][y + 1] = true;
                }
            }
        }

        while (!q2.isEmpty()) {
            int[] curr = q2.poll();
            int x = curr[0];
            int y = curr[1];

            if (x > 0 && heights[x - 1][y] >= heights[x][y]) {
                if (!atlantic[x - 1][y]) {
                    q2.add(new int[]{x - 1, y});
                    atlantic[x - 1][y] = true;
                }
            }

            if (x < heights.length - 1 && heights[x + 1][y] >= heights[x][y]) {
                if (!atlantic[x + 1][y]) {
                    q2.add(new int[]{x + 1, y});
                    atlantic[x + 1][y] = true;
                }
            }

            if (y > 0 && heights[x][y - 1] >= heights[x][y]) {
                if (!atlantic[x][y - 1]) {
                    q2.add(new int[]{x, y - 1});
                    atlantic[x][y - 1] = true;
                }
            }

            if (y < heights[0].length - 1 && heights[x][y + 1] >= heights[x][y]) {
                if (!atlantic[x][y + 1]) {
                    q2.add(new int[]{x, y + 1});
                    atlantic[x][y + 1] = true;
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < pacific.length; i++) {
            for (int j = 0; j < pacific[0].length; j++) {
                if (pacific[i][j]) {
                    if (atlantic[i][j]) {
                        List<Integer> pos = new ArrayList<>();
                        pos.add(i);
                        pos.add(j);
                        result.add(pos);
                    }
                }
            }
        }
        return result;
    }
}
