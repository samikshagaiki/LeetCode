class Solution {
    public int findKthNumber(int n, int k) {
        int current = 1;
        k = k - 1;

        while (k > 0) {
            long steps = countSteps(n, current, current + 1);
            if (steps <= k) {
                // Move to next sibling
                current += 1;
                k -= steps;
            } else {
                // Move to first child
                current *= 10;
                k -= 1;
            }
        }
        return current;
    }

    private long countSteps(int n, long first, long last) {
        long steps = 0;
        while (first <= n) {
            steps += Math.min(n + 1, last) - first;
            first *= 10;
            last *= 10;
        }
        return steps;
    }
}
