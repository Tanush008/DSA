class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
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

    public int countToTarget(int[] coins, int index, int Target, int dp[][]) {
        if (index == 0) {
            if (Target % coins[index] == 0) {
                dp[index][Target] = Target / coins[index];
                return Target / coins[index];
            }
            dp[index][Target] = Target / coins[index];
            return (int) (1e9);
        }
        if (dp[index][Target] != -1) {
            return dp[index][Target];
        }
        int pick = (int) (1e9);
        if (Target >= coins[index]) {
            pick = 1 + countToTarget(coins, index, Target - coins[index], dp);
        }
        int noPick = countToTarget(coins, index - 1, Target, dp);
        dp[index][Target] = Math.min(pick, noPick);
        return dp[index][Target];
    }
}