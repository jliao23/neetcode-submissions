/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals.size() == 0) {
            return 0;
        }

        if (intervals.size() == 1) {
            return 1;
        }
        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.end - b.end);
        int max = 1;
        pq.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if (interval.start >= pq.peek().end) {
                pq.poll();
            }
            pq.offer(interval);

            max = Math.max(max, pq.size());
        }

        return max;
    }
}
