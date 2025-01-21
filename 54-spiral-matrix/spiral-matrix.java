class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int sr = 0;
        int sc = 0;
        int ec = m - 1;
        int er = n - 1;
        while (sr <= er && sc <= ec) {
            // first row
            for (int i = sc; i <= ec; i++) {
                ans.add(matrix[sr][i]);
            }
            sr+=1;
            // end col
            for (int i = sr; i <= er; i++) {
                ans.add(matrix[i][ec]);
            }
            ec-=1;
            if (sr <= er) {
                // last row
                for (int i = ec; i >= sc; i--) {
                    ans.add(matrix[er][i]);
                }
                er-=1;
            }
            if (sc <= ec) {
                // first col
                for (int i = er; i >= sr; i--) {
                    ans.add(matrix[i][sc]);
                }
                sc++;
            }
        }
        return ans;
    }
}