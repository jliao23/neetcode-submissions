class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, 0, target, res, new ArrayList<>());
        return res;
    }

    private void backtrack(int[] nums, int i, int target, List<List<Integer>> res, List<Integer> curr) {
        if (target == 0) {
            res.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0 || i >= nums.length) {
            return;
        }
        curr.add(nums[i]);
        backtrack(nums, i, target - nums[i], res, curr);
        curr.remove(curr.size() - 1);
        backtrack(nums, i + 1, target, res, curr);
    }
}
