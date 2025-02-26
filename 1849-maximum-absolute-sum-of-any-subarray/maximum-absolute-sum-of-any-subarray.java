class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int currPSum = 0;
        int currNSum = 0;
        for (int i : nums) {
            currPSum += i;
            maxSum = Math.max(maxSum, currPSum);
            if (currPSum < 0) {
                currPSum = 0;
            }
            currNSum += i;
            minSum = Math.min(minSum, currNSum);
            if (currNSum > 0) {
                currNSum = 0;
            }
        }
        return Math.max(maxSum, Math.abs(minSum));
    }
}