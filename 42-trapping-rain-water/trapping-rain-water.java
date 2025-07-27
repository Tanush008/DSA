class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;
        int left = 0;
        int right = n - 1;
        int rightMax = 0;
        int leftMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] > leftMax) {
                    leftMax = height[left];
                } else {
                    res += Math.abs(height[left] - leftMax);
                }
                left++;
            } else {
                if (height[right] > rightMax) {
                    rightMax = height[right];
                } else {
                    res += Math.abs(height[right] - rightMax);
                }
                right--;
            }
        }
        return res;
    }

}