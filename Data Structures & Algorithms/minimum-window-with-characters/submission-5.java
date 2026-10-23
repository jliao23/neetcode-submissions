class Solution {
    public String minWindow(String s, String t) {
        String best = s;
        int formed = 0;
        boolean flag = false;
        Map<Character, Integer> valid = new HashMap<>();
        Map<Character, Integer> counter = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            valid.put(t.charAt(i), valid.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = -1;

        while (right < s.length() - 1) {
            right++;
            if (valid.containsKey(s.charAt(right))) {
                counter.put(s.charAt(right), counter.getOrDefault(s.charAt(right), 0) + 1);
                if (counter.get(s.charAt(right)).intValue() == valid.get(s.charAt(right)).intValue()) {
                    formed++;
                }
            }
            
            if (formed == valid.size()) {
                flag = true;
            }

            while (formed == valid.size()) {
                if (!valid.containsKey(s.charAt(left))) {
                    left++;
                } else {
                    counter.put(s.charAt(left), counter.get(s.charAt(left)) - 1);
                    if (counter.get(s.charAt(left)) < valid.get(s.charAt(left))) {
                        formed--;
                    }
                    if (right + 1 - left < best.length()) {
                        best = s.substring(left, right + 1);
                    }
                    left++;
                }
            }
        }

        if (flag) {
            return best;
        }
        return "";
    }
}
