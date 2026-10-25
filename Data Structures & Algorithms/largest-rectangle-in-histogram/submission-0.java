class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 1) {
            return heights[0];
        }

        int maxArea = 0;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{0, heights[0]});
        
        for (int i = 1; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                int[] curr = stack.pop();
                int currArea = (i - curr[0]) * curr[1];
                maxArea = Math.max(currArea, maxArea);
                start = curr[0];
            }

            stack.push(new int[]{start, heights[i]});
        }

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();
            int currArea = (heights.length - curr[0]) * curr[1];
            maxArea = Math.max(currArea, maxArea);
        }

        return maxArea;
    }


}
