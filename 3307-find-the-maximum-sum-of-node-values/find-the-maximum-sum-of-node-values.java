import java.util.*;

class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long baseSum = 0;
        List<Integer> gains = new ArrayList<>();

        // Step 1: Compute gain for each node and base sum
        for (int num : nums) {
            int xorVal = num ^ k;
            int gain = xorVal - num;
            baseSum += num;
            gains.add(gain);
        }

        // Step 2: Sort gains descending to pick the biggest ones
        gains.sort(Collections.reverseOrder());

        long maxGain = 0, currentGain = 0;
        int count = 0;

        // Step 3: Try applying even number of max gains
        for (int g : gains) {
            currentGain += g;
            count++;

            if (count % 2 == 0) {
                maxGain = Math.max(maxGain, currentGain);
            }
        }

        // Step 4: Return total sum after best even set of XORs
        return baseSum + maxGain;
    }
}
