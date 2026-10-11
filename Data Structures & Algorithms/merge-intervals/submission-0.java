class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int[] curr = res.get(0);

        for (int [] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            if (start <= curr[1]) {
                curr[1] = Math.max(curr[1], end);
            } else {
                res.add(interval);
                curr = res.get(res.size() - 1);
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
