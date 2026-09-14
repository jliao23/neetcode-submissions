class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int[] nums;
    boolean[] used;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        used = new boolean[nums.length];
        List<Integer> current = new ArrayList<>();
        backtrack(current);
        return list;
    }

    public void backtrack(List<Integer> current){
        if(current.size()==nums.length){
            list.add(new ArrayList<>(current));
            return;
        }
        for(int i=0;i<nums.length;i++){

            if(used[i] == true){
                continue;
            }
            current.add(nums[i]);
            used[i] = true;
            backtrack(current);
            used[i] = false;
            current.remove(current.size()-1);


        }



    }

}
