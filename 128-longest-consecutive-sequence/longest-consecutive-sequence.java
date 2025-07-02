class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        // Map<Integer, Boolean> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        // int count = 0;
        int longest = 0;
        for (int i = 0; i < n; i++) {
            // map.put(nums[i], true);
            set.add(nums[i]);
        }
        // for (int i = 0; i < n; i++) {
        //     int right = nums[i];
        //     int nxt = right + 1;
        //     if (map.containsKey(nxt)) {
        //         count++;
        //     }
        // }
        for (int it : set) {
            if (!set.contains(it - 1)) {
                int count = 1;
                int nxt = it;
                while (set.contains(nxt + 1)) {
                    nxt += 1;
                    count++;
                }
                longest = Math.max(longest, count);
            }
        }
        return longest;
    }
}