import java.util.*;

class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        // Step 1: Create pairs of (value, index)
        int n = nums.length;
        int[][] pairs = new int[n][2]; // [value, index]
        
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums[i];
            pairs[i][1] = i;
        }
        
        // Step 2: Sort by value descending
        Arrays.sort(pairs, (a, b) -> Integer.compare(b[0], a[0]));
        
        // Step 3: Pick top k and sort them by original index
        Arrays.sort(pairs, 0, k, Comparator.comparingInt(a -> a[1]));
        
        // Step 4: Extract the values
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pairs[i][0];
        }
        
        return result;
    }
}
