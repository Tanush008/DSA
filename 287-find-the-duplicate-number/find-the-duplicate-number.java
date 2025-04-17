class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        boolean[] visit = new boolean[n];
        for (int num : nums) {
            if (visit[num]) {
                return num;
            } else {
                visit[num] = true;
            }
        }
        return -1;
    }
}