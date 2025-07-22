class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> currComb = new ArrayList<>();
        solve(currComb, 1, k, n, res);
        return res;
    }

    public void solve(List<Integer> currComb, int start, int k, int n, List<List<Integer>> res) {
        if (n == 0 && currComb.size() == k) {
            res.add(new ArrayList<>(currComb));
            return;
        }
        if (n < 0 || currComb.size() > k) {
            return;
        }
        if (k > n) {
            return;
        }
        for (int i = start; i <= 9; i++) {
            if (i > n) {
                break;
            }
            if (currComb.size() > k) {
                break;
            }
            currComb.add(i);

            solve(currComb, i + 1, k, n - i, res);
            currComb.remove(currComb.size() - 1);
        }
    }
}