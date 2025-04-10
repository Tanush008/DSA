class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;    
        // List<Integer>ans = new ArrayList<>();
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        for(int num:nums){
            pq.offer(num);
        }
        int i = 0;
        while(!pq.isEmpty()){
           nums[i++] = pq.poll();
        }
    }
}