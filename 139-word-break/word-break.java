class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i[] : dp) {
            Arrays.fill(i, -1);
        }
        return solve(s, 0, 0, new HashSet<>(wordDict), dp);
    }

    public boolean solve(String s, int start, int end, Set<String> wd, int[][] dp) {
        if (dp[start][end] != -1) {
            return dp[start][end] == 1 ? true : false;
        }
        if (end == s.length() - 1) {
            if (wd.contains(s.substring(start, end + 1))) {
                return true;
            }
            return false;
        }
        if (wd.contains(s.substring(start, end + 1))) {
            if (solve(s, end + 1, end + 1, wd, dp)) {
                dp[start][end] = 1;
                return true;
            }
        }
        boolean ans = solve(s, start, end + 1, wd, dp);
        dp[start][end] = ans ? 1 : 0;
        return ans;
    }
}