class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(res, temp, nums, 0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int i) {
        if (i >= nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        dfs(res, temp, nums, i + 1);
        temp.remove(temp.size() - 1);
        dfs(res, temp, nums, i + 1);
    }
}
