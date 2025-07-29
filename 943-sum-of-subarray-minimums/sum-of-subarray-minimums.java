class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] pse = pse(arr);
        int[] nse = nse(arr);
        int total = 0;
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < n; i++) {
            int left = i-pse[i];
            int right = nse[i]-i;
           total = (total + (int) ((long) left * right * arr[i] % mod)) % mod;
        }
        return total;
    }

    public int[] nse(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i>=0; i--) {
            while (!st.isEmpty() && arr[i] <= arr[st.peek()]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }

    public int[] pse(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[i] < arr[st.peek()]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }
}