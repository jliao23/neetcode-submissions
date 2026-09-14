class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Arrays.stream(piles).max().getAsInt();

        int left = 1;
        int right = max;
        int mid = (right - left) / 2;

        while (left <= right) {
            mid = left + (right - left) / 2;

            int count = 0;
            for (int pile : piles) {
                if (pile % mid != 0) {
                    count+= 1 + pile / mid;
                } else {
                    count+= pile / mid;
                }
            }

            if (count <= h) {
                right = mid - 1; 
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}

