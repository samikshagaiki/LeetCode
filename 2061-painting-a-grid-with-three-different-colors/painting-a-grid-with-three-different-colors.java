class Solution {

    private static final int MOD = 1_000_000_007;

    public int colorTheGrid(int m, int n) {

        List<int[]> patterns = new ArrayList<>();
        generatePatterns(m, 0, new int[m], patterns);

        Map<String, Integer> patternIndex = new HashMap<>();
        for (int i = 0; i < patterns.size(); i++) {
            patternIndex.put(Arrays.toString(patterns.get(i)), i);
        }

        int pSize = patterns.size();
        long[][] dp = new long[n][pSize];

        // Initialize first column
        for (int i = 0; i < pSize; i++) {
            dp[0][i] = 1;
        }

        // Precompute compatibility
        boolean[][] compatible = new boolean[pSize][pSize];
        for (int i = 0; i < pSize; i++) {
            for (int j = 0; j < pSize; j++) {
                if (isCompatible(patterns.get(i), patterns.get(j))) {
                    compatible[i][j] = true;
                }
            }
        }

        // Fill DP table
        for (int col = 1; col < n; col++) {
            for (int i = 0; i < pSize; i++) {
                for (int j = 0; j < pSize; j++) {
                    if (compatible[i][j]) {
                        dp[col][i] = (dp[col][i] + dp[col - 1][j]) % MOD;
                    }
                }
            }
        }

        // Sum all possibilities for last column
        long result = 0;
        for (int i = 0; i < pSize; i++) {
            result = (result + dp[n - 1][i]) % MOD;
        }

        return (int) result;
    }

    private void generatePatterns(int m, int idx, int[] curr, List<int[]> patterns) {
        if (idx == m) {
            patterns.add(Arrays.copyOf(curr, m));
            return;
        }
        for (int c = 0; c < 3; c++) {
            if (idx > 0 && curr[idx - 1] == c) continue;
            curr[idx] = c;
            generatePatterns(m, idx + 1, curr, patterns);
        }
    }

    private boolean isCompatible(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == b[i]) return false;
        }
        return true;
    }
}
