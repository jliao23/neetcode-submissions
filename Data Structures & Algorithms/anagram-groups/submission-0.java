class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> groups = new ArrayList<>();

        for (String str : strs) {
            int flag = 0;
            char[] copy = str.toCharArray();
            Arrays.sort(copy);
            
            for (List<String> group : groups) {
                char[] temp = group.get(0).toCharArray();
                Arrays.sort(temp);

                if (Arrays.equals(temp, copy)) {
                    group.add(str);
                    flag = 1;
                }
            }

            if (flag == 0) {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                groups.add(newGroup);
            }
        }

        return groups;
    }
}
