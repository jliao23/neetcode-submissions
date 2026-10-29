class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        visited.add(beginWord);
        int res = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (curr.equals(endWord)) {
                    return res;
                }

                for (String word : wordList) {
                    if (visited.contains(word)) {
                        continue;
                    } 

                    int count = 0;
                    for (int j = 0; j < word.length(); j++) {
                        if (word.charAt(j) != curr.charAt(j)) {
                            count++;
                        }
                    }

                    if (count == 1) {
                        q.offer(word);
                        visited.add(word);
                    }
                }
            }

            res++;
        }

        return 0;
    }
}
