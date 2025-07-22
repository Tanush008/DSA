class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int subset = 1 << n;
        // List<List<Integer>>res = new ArrayList<>();
        Set<List<Integer>> uni = new HashSet<>();
        for (int i = 0; i < subset; i++) {
            List<Integer> ans = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    ans.add(nums[j]);
                }
            }
            uni.add(ans);
        }
        return new ArrayList<>(uni);
    }

}