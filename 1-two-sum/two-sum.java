class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int ans[] = new int[2];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int right = nums[i];
            int left = target - nums[i];
            if (map.containsKey(left)) {
                ans[0] = map.get(left);
                ans[1] = i;
                return ans;
            }
            map.put(nums[i], i);
        }
        return ans;
    }
}