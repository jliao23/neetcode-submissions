class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> solution = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (solution.containsKey(nums[i])) {
                int[] result = new int[2];
                result[0] = solution.get(nums[i]);
                result[1] = i;
                return result;
            } else {
                solution.put(target - nums[i], i);
            }
        }

        return new int[2];
    }
}
