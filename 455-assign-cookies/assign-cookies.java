class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0, ans = 0;
        for (int i : g) {
            while (s.length > j && s[j] < i) {
                j++;
            }
            if (s.length == j) {
                return ans;
            } else {
                j++;
                ans++;
            }

        }
        return ans;
    }
}