class Solution {
    Double[][] dp;

    public double soupServings(int n) {
        if (n > 5000) {
            return 1.0;
        }
        int units = (int) Math.ceil(n / 25.0);
        dp = new Double[units + 1][units + 1];
        return solve(units, units);
    }

    public double solve(int soupA, int soupB) {
        if (soupA <= 0 && soupB <= 0) {
            return 0.5;
        }
        if (soupA <= 0) {
            return 1.0;
        }
        if (soupB <= 0) {
            return 0.0;
        }
        if (dp[soupA][soupB] != null) {
            return dp[soupA][soupB];
        }
        double calProb = 0.25 * (solve(soupA - 4, soupB) + solve(soupA - 3, soupB - 1) + solve(soupA - 2, soupB - 2)
                + solve(soupA - 1, soupB - 3));
        return dp[soupA][soupB] = calProb;
    }
}