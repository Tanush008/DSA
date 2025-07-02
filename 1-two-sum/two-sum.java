class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            int right = nums[i];
            int left = target - right;

            if (map.containsKey(left)) {
                ans[1] = map.get(left);
                ans[0] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}