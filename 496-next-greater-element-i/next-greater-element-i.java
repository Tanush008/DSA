class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> mp = new HashMap<>();
        for (int j = m - 1; j >= 0; j--) {
            int curr = nums2[j];
            while (!st.isEmpty() && curr >= st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) {
                mp.put(curr, -1);
            } else {
                mp.put(curr, st.peek());
            }
            st.push(nums2[j]);
        }
        for (int i = 0; i < n; i++) {
            nge[i] = mp.get(nums1[i]);
        }
        return nge;
    }
}