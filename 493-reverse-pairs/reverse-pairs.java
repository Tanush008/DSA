class Solution {
    public int reversePairs(int[] nums) {
        int n = nums.length;
        return merge(nums, 0, n - 1);
    }

    public int merge(int[] nums, int low, int high) {
        if (low >= high) {
            return 0;
        }
        int mid = low + (high - low) / 2;
        int c = 0;
        c += merge(nums, low, mid);
        c += merge(nums, mid + 1, high);
        c += mergeSort(nums, low, mid, high);
        return c;
    }

    public int mergeSort(int[] nums, int low, int mid, int high) {
        int c = 0;
        int j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && (long) nums[i] > 2L * nums[j]) {
                j++;
            }
            c += (j - (mid + 1));
        }
        int[] temp = new int[high - low + 1];
        int left = low;
        int right = mid + 1;
        int k = 0;
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[k++] = nums[left++];
            } else {
                temp[k++] = nums[right++];
            }
        }
        while (left <= mid) {
            temp[k++] = nums[left++];
        }
        while (right <= high) {
            temp[k++] = nums[right++];
        }
        for ( k = 0; k < temp.length; k++) {
            nums[low + k] = temp[k];
        }
        return c;
    }
}