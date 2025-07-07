class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int i = n - 2;
        while(i>=0&&nums[i]>=nums[i+1]){
            i--;
        }
        if(i>=0){
            int j= n-1;
            while(j>0&&nums[j]<=nums[i]){
                j--;
            }
            swap(nums,i,j);
        }
        reverse(nums,i+1,n-1);
    }

    public void swap(int[] nums, int a, int b) {
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] =  c;
    }
    public void reverse(int[]nums,int strt,int end){
        while(strt<end){
            swap(nums,strt,end);
            strt++;
            end--;
        }
    }
}