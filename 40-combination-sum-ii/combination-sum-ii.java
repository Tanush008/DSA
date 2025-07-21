class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> currComb = new ArrayList<>();
        solve(currComb, candidates, 0, res, target);
        return res;
    }

    public void solve(List<Integer> currComb, int[] candi, int index, List<List<Integer>> res, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(currComb));
            return;
        }
        if (candi.length == index || target < 0) {
            return;
        }
        for (int i = index; i < candi.length; i++) {
            if (i > index && candi[i] == candi[i - 1]) {
                continue;
            }
            if (candi[i] > target) {
                break;
            }
            currComb.add(candi[i]);
            solve(currComb, candi, i + 1, res, target - candi[i]);
            currComb.remove(currComb.size() - 1);
        }
    }
}