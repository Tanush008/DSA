class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n][n];
        int maxLen = 0;
        for (int i = 2; i < n; i++) {
            int start = 0;
            int end = i - 1;
            while (start < end) {
                int sum = arr[start] + arr[end];
                if (sum > arr[i]) {
                    end--;
                } else if (arr[i] > sum) {
                    start++;
                } else {
                    dp[end][i] = dp[start][end] + 1;
                    maxLen = Math.max(maxLen, dp[end][i]);
                    start++;
                    end--;
                }
            }
        }
        return (maxLen == 0) ? 0 : maxLen + 2;
    }
}