class Solution {
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        int[] combo = new int[n];
        combo[0] = 1;
        combo[1] = 2;

        for (int i = 2; i < n; i++) {
            combo[i] = combo[i - 1] + combo[i - 2];
        }

        return combo[n - 1];
    }
}
