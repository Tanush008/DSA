class Solution {
    public String longestPrefix(String s) {
        char[] ch = s.toCharArray();
        int n = ch.length;
        int z[] = new int[n];
        int l = 0, r = 0;
        for (int i = 1; i < n; i++) {
            z[i] = Math.max(0, Math.min(z[i - l], r - i + 1));
            while (i + z[i] < n && ch[z[i]] == ch[i + z[i]]) {
                l = i;
                r = i + z[i];
                z[i]++;
            }
            if (i + z[i] == n) {
                return s.substring(i);
            }
        }
        return "";
    }
}