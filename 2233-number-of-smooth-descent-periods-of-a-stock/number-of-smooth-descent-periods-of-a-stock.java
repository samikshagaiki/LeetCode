class Solution {
    public long getDescentPeriods(int[] prices) {
        long total = 1; 
        long current = 1;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                current++;
            } else {
                current = 1;
            }
            total += current;
        }

        return total;
    }
}
