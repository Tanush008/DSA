class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add((long)nums[i]);
        }
        int count = 0;
        while (pq.size() >= 2) {
            long x = pq.poll();
            if (x >= k) {
                break;
            }
            long y = pq.poll();
            long res = Math.min(x, y) * 2 + Math.max(x, y);
            pq.add(res);
            count++;
        }
        return count;
    }
}