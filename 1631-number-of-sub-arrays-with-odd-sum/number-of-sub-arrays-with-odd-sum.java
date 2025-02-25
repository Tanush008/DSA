class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int mod = 1000000007;
        int prefixSum = 0;
        int evenCount = 1;
        int oddCount = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if (prefixSum % 2 == 0) {
                count += oddCount;
                evenCount++;
            } else {
                count += evenCount;
                oddCount++;
            }
            count = count % mod;
        }
        return count;

    }
}