class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= n; i++) {
            int ele = (i == n) ? 0 : heights[i];
            while (!st.isEmpty() && heights[st.peek()] > ele) {
                int h = heights[st.pop()];
                int ps = st.isEmpty() ? -1 : st.peek();
                int w = i - ps - 1;
                max = Math.max(max, h * w);
            }
            st.push(i);
        }
        return (max == Integer.MIN_VALUE ? 0 : max);
    }
}