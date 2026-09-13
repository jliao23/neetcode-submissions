class Solution {

    public String encode(List<String> strs) {
        String str = "";
        for (String curr : strs) {
            str = str + curr.length() + "#" + curr;
        }
        return str;
    }

    public List<String> decode(String str) {
        List<String> words = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') {
                j++;
            }

            int curr = Integer.parseInt(str.substring(i, j));
            words.add(str.substring(j + 1, j + 1 + curr));

            i = j + 1 + curr;
        }

        return words;
    }
}
