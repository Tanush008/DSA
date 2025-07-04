class Solution {
    public int uniquePaths(int m, int n) {
        int t[][] = new int[m][n];
        for (int[] i : t) {
            Arrays.fill(i, -1);
        }
        return solve(m-1, n-1, t);
    }

    public int solve(int m, int n, int[][] t) {

        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 0 && n == 0) {
            return 1;
        }
        if (t[m][n] != -1) {
            return t[m][n];
        }
        int down = solve(m, n - 1, t);
        int right = solve(m - 1, n, t);
        return t[m][n] = down + right;
    }
}