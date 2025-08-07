class Solution {
    int n;

    public int maxCollectedFruits(int[][] fruits) {
        n = fruits.length;
        int[][] dp = new int[n+1][n+1];
        for (int[] i : dp) {
            Arrays.fill(i, -1);
        }
        int child1 = child1(fruits);
        int child2 = child2(0, n - 1, fruits,dp);
        int child3 = child3(n - 1, 0, fruits,dp);
        return child1 + child2 + child3;
    }

    public int child1(int[][] fruits) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            count += fruits[i][i];
        }
        return count;
    }

    public int child2(int i, int j, int[][] fruits,int[][]dp) {
        if (i >= n || j < 0 || j >= n) {
            return 0;
        }
        if (i == n - 1 && j == n - 1) {
            return 0;
        }
        if (i == j || i > j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int bottomleft = fruits[i][j] + child2(i + 1, j - 1, fruits,dp);
        int bottomDown = fruits[i][j] + child2(i + 1, j, fruits ,dp);
        int bottomRight = fruits[i][j] + child2(i + 1, j + 1, fruits ,dp);
        return dp[i][j] = Math.max(bottomleft, Math.max(bottomDown, bottomRight));

    }

    public int child3(int i, int j, int[][] fruits ,int[][]dp) {
        if (i >= n || j < 0 || j >= n) {
            return 0;
        }
        if (i == n - 1 && j == n - 1) {
            return 0;
        }
        if (i < j || i == j) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int left = fruits[i][j] + child3(i - 1, j + 1, fruits ,dp);
        int Down = fruits[i][j] + child3(i, j + 1, fruits ,dp);
        int Right = fruits[i][j] + child3(i + 1, j + 1, fruits ,dp);
        return dp[i][j] = Math.max(left, Math.max(Down, Right));
    }
}
