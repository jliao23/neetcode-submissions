class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = 0;
        int r = s1.length();

        while (r <= s2.length()) {
            String temp = s2.substring(l, r);
            if (isPermutation(s1, temp)) {
                return true;
            }

            l += 1;
            r += 1;
        }

        return false;
    }

    public boolean isPermutation(String s1, String s2) {
        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);

            if (count1.containsKey(a)) {
                count1.put(a, count1.get(a) + 1);
            } else {
                count1.put(a, 1);
            }

            if (count2.containsKey(b)) {
                count2.put(b, count2.get(b) + 1);
            } else {
                count2.put(b, 1);
            }
        }

        if (count1.equals(count2)) {
            return true;
        }

        return false;
    }
}
