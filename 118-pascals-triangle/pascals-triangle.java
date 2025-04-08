class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                temp.add(pascal(i - 1, j - 1));
            }
            res.add(temp);
        }
        return res;
    }

    public int pascal(int n, int r) {
        int ans = 1;
        for (int i = 0; i < r; i++) {
            ans = ans * (n - i);
            ans = ans / (i + 1);
        }
        return ans;
    }
}