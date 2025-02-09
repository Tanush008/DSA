class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        // long count = 0;
        Map<Integer, Long> map = new HashMap<>();
        long total = (n * (n - 1L) / 2);
        long goodpair = 0;
        for (int i = 0; i < n; i++) {
            int key = i-nums[i];
            goodpair += map.getOrDefault(key,0L);
            map.put(key,map.getOrDefault(key,0L)+1);
        }
        return total - goodpair;
    }
}
// tujhe ek cheez dikha tha hu
// test case kitna bda aayega ek abi
// dekh kitna bda h

// mujhe nahi dikhega vo 
// ok