class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int dp[][] = lcs(str1, str2);
        int n = dp.length;
        int m = dp[0].length;
        int i = n - 1;
        int j = m - 1;
        StringBuilder res = new StringBuilder();
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                res.append(str1.charAt(i-1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                res.append(str1.charAt(i - 1));
                i--;
            } else {
                res.append(str2.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            res.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            res.append(str2.charAt(j - 1));
            j--;
        }
        return res.reverse().toString();
    }

    public int[][] lcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int case1 = dp[i - 1][j];
                    int case2 = dp[i][j - 1];
                    dp[i][j] = Math.max(case1, case2);
                }
            }
        }
        return dp;
    }
}