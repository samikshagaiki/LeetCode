public class Solution {
    public long distributeCandies(int n, int lim) {
        long res = 0;

        for (long a = Math.max(0, n - 2L * lim); a <= Math.min(n, lim); a++) {
            long bMin = Math.max(0, n - lim - a);
            long bMax = Math.min(n - a, lim);

            if (bMin <= bMax) {
                res += (bMax - bMin + 1);
            }
        }

        return res;
    }
}
