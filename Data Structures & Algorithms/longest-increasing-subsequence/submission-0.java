class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lengths = new int[nums.length];
        Arrays.fill(lengths, 1);

        for (int i = 1; i < nums.length; i++) {
            List<Integer> candidates = new ArrayList<>();
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    candidates.add(lengths[j]);
                }
            }

            for (int candidate : candidates) {
                max = Math.max(max, candidate); 
            }

            lengths[i] = max + 1;
        }

        int max = 0;
        for (int num : lengths) {
            max = Math.max(max, num);
        }

        return max;
    }
}
