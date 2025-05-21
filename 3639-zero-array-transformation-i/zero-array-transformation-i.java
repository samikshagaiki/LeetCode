class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] operationCount = new int[n + 1]; 

        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            operationCount[l] += 1;
            if (r + 1 < n) {
                operationCount[r + 1] -= 1;
            }
        }

        for (int i = 1; i < n; i++) {
            operationCount[i] += operationCount[i - 1];
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > operationCount[i]) {
                return false; 
            }
        }

        return true; 
    }
}