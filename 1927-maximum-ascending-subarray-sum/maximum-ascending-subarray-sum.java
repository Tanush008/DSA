class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int res = 0;
        int currSum = 0;
        for (int i = 0; i < n; i++) {
            if (i==0||nums[i] > nums[i - 1]) {
                currSum += nums[i];
            } else {
                res = Math.max(currSum, res);
                currSum = nums[i];
            }
        }
        res = Math.max(res,currSum);
        return res;
    }
}