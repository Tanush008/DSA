class Solution {
    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int max = -1;
        for (int i : nums) {
            int digitSum = 0;
            int temp = i;
            while (temp != 0) {
                digitSum += temp % 10;
                temp /= 10;
            }
            if (map.containsKey(digitSum)) {
                max = Math.max(max, map.get(digitSum) + i);
            }
            map.put(digitSum, Math.max(map.getOrDefault(digitSum, i),i));
        }
        return max;
    }
}