class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int longest = 0;

        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int length = 1;
                while (set.contains(num + 1)) {
                    length++;
                    num++;
                }

                if (length > longest) {
                    longest = length;
                }
            }
        }

        return longest;
    }
}
