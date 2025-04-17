class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        // if (count > 0) {
        //     return count;
        // }
        return count;
    }
}