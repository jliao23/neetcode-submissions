class Solution {
    public int maxProfit(int[] prices) {
        int lowest = prices[0];
        int max = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < lowest) {
                lowest = prices[i];
            } else if (prices[i] - lowest > max) {
                max = prices[i] - lowest;
            }
        }

        return max;
    }
}
