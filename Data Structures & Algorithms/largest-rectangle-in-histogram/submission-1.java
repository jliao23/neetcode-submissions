class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] curr = stack.pop();
                start = curr[0];
                int height = curr[1];
                maxArea = Math.max(maxArea, height * (i - start));
            }
            stack.push(new int[]{start, heights[i]});
        }

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            maxArea = Math.max(maxArea, (heights.length - curr[0]) * curr[1]);
        }

        return maxArea;
    }
}
