class Solution {
    private static final int MOD = 1_000_000_007;

    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        
        // Precompute powers of 2 up to n
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % MOD;
        }

        int left = 0, right = n - 1;
        int result = 0;

        while (left <= right) {
            if (nums[left] + nums[right] <= target) {
                // All combinations of elements between left and right
                result = (result + pow[right - left]) % MOD;
                left++;
            } else {
                right--;
            }
        }

        return result;
    }
}
