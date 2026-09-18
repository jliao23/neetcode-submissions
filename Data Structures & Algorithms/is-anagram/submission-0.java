class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> word1 = new HashMap<>();
        Map<Character, Integer> word2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            word1.put(s.charAt(i), word1.getOrDefault(s.charAt(i), 0) + 1);
            word2.put(t.charAt(i), word2.getOrDefault(t.charAt(i), 0) + 1);
        }
        return word1.equals(word2);
    }
}
