class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String sorted = new String(temp);

            if (map.containsKey(sorted)) {
                map.get(sorted).add(str);
            } else {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(str);
                map.put(sorted, newGroup);
            }
        }

        return new ArrayList<>(map.values());
    }
}
