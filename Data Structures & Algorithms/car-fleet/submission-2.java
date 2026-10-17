class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        if (position.length == 1) {
            return 1;
        }

        int[][] pairs = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            pairs[i][0] = position[i];
            pairs[i][1] = speed[i];
        }

        Arrays.sort(pairs, (a, b) -> b[0] - a[0]);
        int count = 1;
        double curr = (target - pairs[0][0]) / pairs[0][1];
        for (int i = 1; i < pairs.length; i++) {
            int[] pair = pairs[i];
            if (!((double) (target - pair[0]) / pair[1] <= curr)) {
                count++;
                curr = (double) (target - pair[0]) / pair[1];  
            }
        }

        return count;
    }
}
