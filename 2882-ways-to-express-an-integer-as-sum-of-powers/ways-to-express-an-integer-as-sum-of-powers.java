class Solution {
    static final int M = 1000000007;
    int[][] dp;
    public int numberOfWays(int n, int x) {
        dp = new int[n+1][n+1];
        for(int[]i:dp){
            Arrays.fill(i,-1);
        }
        return solve(n, 0, x, 1);
    }

    public int solve(int n, int sum, int x, int num) {
        if (sum == n) {
            return 1;
        }
        int rem = (int) Math.pow(num, x);
        if (sum + rem > n) {
            return 0;
        }
        if (dp[num][sum] != -1) {
            return dp[num][sum];
        }
        int take = solve(n, sum + rem, x, num + 1);
        int notTake = solve(n, sum, x, num + 1);
        return dp[num][sum] = (int) ((take + (long) notTake) % M);
    }

}