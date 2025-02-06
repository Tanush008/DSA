class Solution {
    public int tupleSameProduct(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        // int res = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int res = nums[i] * nums[j];
                map.put(res, map.getOrDefault(res, 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int prd = entry.getKey();
            int count = entry.getValue();

            if (count >= 2) {
                int comb = (count * (count - 1)) / 2;
                ans += 8 * comb;
            }
        }
        return ans;
    }
}