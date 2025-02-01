class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        // int[][] dp = new int[n][amount + 1];
        // for (int T = 0; T <= amount; T++) {
        // dp[0][T] = (T % coins[0] == 0) ? 1 : 0;
        // }
        // for (int i = 1; i < n; i++) {
        // for (int t = 0; t <=amount; t++) {
        // int notaken = dp[i - 1][t];
        // int taken = (t >= coins[i]) ? dp[i][t - coins[i]] : 0;
        // dp[i][t] = taken + notaken;
        // }
        // }
        // return dp[n - 1][amount];
        int[][] dp = new int[n][amount + 1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        int ans = countToTarget(coins, n - 1, amount, dp);
        if (ans >= (int) (Math.pow(10, 9))) {
            return -1;
        } else {
            return ans;
        }
    }

    public int countToTarget(int[] arr, int i, int T, int dp[][]) {
        if (i == 0) {
            if (T % arr[0] == 0) {
                return T / arr[0];
            } else {
                return (int) (Math.pow(10, 9));
            }
        }
        if (dp[i][T] != -1) {
            return dp[i][T];
        }
        int notaken = 0 + countToTarget(arr, i - 1, T, dp);
        int taken = (int) (Math.pow(10, 9));
        if (T >= arr[i]) {
            taken = 1 + countToTarget(arr, i, T - arr[i], dp);
        }
        return dp[i][T] = Math.min(taken, notaken);
    }
}