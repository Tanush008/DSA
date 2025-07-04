class Solution {
    public int uniquePaths(int m, int n) {
        int t[][] = new int[m][n];
        for (int[] i : t) {
            Arrays.fill(i, -1);
        }
        return solve(0, 0, m, n,t);
    }

    public int solve(int i, int j, int m, int n,int[][]t) {
       
        if (i >= m || j >= n) {
            return 0;
        }
        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (t[i][j] != -1) {
            return t[i][j];
        }
        int down = solve(i + 1, j, m, n,t);
        int right = solve(i, j + 1, m, n,t);
        return t[i][j] = down + right;
    }
}