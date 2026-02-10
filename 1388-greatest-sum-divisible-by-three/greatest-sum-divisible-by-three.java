class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;

        // Store smallest numbers with remainder 1 and 2
        int r1_1 = Integer.MAX_VALUE, r1_2 = Integer.MAX_VALUE;
        int r2_1 = Integer.MAX_VALUE, r2_2 = Integer.MAX_VALUE;

        for (int num : nums) {
            sum += num;

            if (num % 3 == 1) {
                if (num < r1_1) {
                    r1_2 = r1_1;
                    r1_1 = num;
                } else if (num < r1_2) {
                    r1_2 = num;
                }
            } 
            else if (num % 3 == 2) {
                if (num < r2_1) {
                    r2_2 = r2_1;
                    r2_1 = num;
                } else if (num < r2_2) {
                    r2_2 = num;
                }
            }
        }

        if (sum % 3 == 0) return sum;

        if (sum % 3 == 1) {
            int remove1 = r1_1;
            int remove2 = (r2_1 == Integer.MAX_VALUE || r2_2 == Integer.MAX_VALUE)
                          ? Integer.MAX_VALUE
                          : r2_1 + r2_2;
            int remove = Math.min(remove1, remove2);
            return remove == Integer.MAX_VALUE ? 0 : sum - remove;
        }

        // sum % 3 == 2
        int remove1 = r2_1;
        int remove2 = (r1_1 == Integer.MAX_VALUE || r1_2 == Integer.MAX_VALUE)
                      ? Integer.MAX_VALUE
                      : r1_1 + r1_2;
        int remove = Math.min(remove1, remove2);
        return remove == Integer.MAX_VALUE ? 0 : sum - remove;
    }
}
