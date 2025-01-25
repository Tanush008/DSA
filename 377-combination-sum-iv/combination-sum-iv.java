class Solution {
    int[]dp;
    public int combinationSum4(int[] nums, int target) {
        // int n = nums.length;
        dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        helper(nums, target);
        return dp[target];
    }

    public int helper(int nums[], int target) {
        if (dp[target] > -1) {
            return dp[target];
        }
        int res = 0;
        for (int i : nums) {
            if (i <= target) {
                res += helper(nums, target - i);
            }
        }
        dp[target] = res;
        return res;
    }
}