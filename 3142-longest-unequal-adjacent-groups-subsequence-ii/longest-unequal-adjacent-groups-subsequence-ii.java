class Solution {
    int[][] dp;
    String[] w;
    int[] g;
    List<String> ans;

    private boolean fun(String x, String y) {
        if (x.length() != y.length()) return false;
        int cnt = 0;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) != y.charAt(i) && ++cnt > 1)
                return false;
        }
        return cnt == 1;
    }


    private int solve(int ind, int prev) {
        if (ind == w.length) return 0;
        int pi = prev + 1;
        if (dp[ind][pi] != -1) return dp[ind][pi];

       
        int best = solve(ind + 1, prev);

       
        if (prev == -1 || (g[prev] != g[ind] && fun(w[prev], w[ind]))) {
            best = Math.max(best, 1 + solve(ind + 1, ind));
        }

        return dp[ind][pi] = best;
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        this.w = words;
        this.g = groups;
        int n = words.length;
        dp = new int[n + 1][n + 2];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], -1);
        }

       
        solve(0, -1);

       
        ans = new ArrayList<>();
        int ind = 0, prev = -1;
        while (ind < n) {
            int pi = prev + 1;
            int skip = dp[ind + 1][pi];
            int take = -1;
            if (prev == -1 || (g[prev] != g[ind] && fun(w[prev], w[ind]))) {
                take = 1 + dp[ind + 1][ind + 1];
            }
            if (take > skip) {
                ans.add(w[ind]);
                prev = ind;
            }
            ind++;
        }
        return ans;
    }
}
