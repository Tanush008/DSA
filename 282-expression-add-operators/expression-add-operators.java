class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        // List<String> res = new ArrayList<>();
        // int n = num.length();
        // if (num == null || num.isEmpty()) {
        //     return res;
        // }
        solve(0, num, target, ans, "", 0, 0);
        return ans;
    }

    public void solve(int startidx, String s, int target, List<String> ans, String curr, long prev, long res) {
        if (s.length() == startidx) {
            if (res == target) {
                ans.add(curr);
            }
            return;
        }
        String st = "";
        long currRes = 0;
        for (int i = startidx; i < s.length(); i++) {
            if (i > startidx && s.charAt(startidx) == '0') {
                break;
            }
            st += s.charAt(i);
            currRes = currRes * 10 + (s.charAt(i) - '0');
            if (startidx == 0) {
                solve(i + 1, s, target, ans, st, currRes, currRes);
            } else {
                solve(i + 1, s, target, ans, curr + "+" + st, currRes, currRes + res);
                solve(i + 1, s, target, ans, curr + "*" + st,prev * currRes,res - prev + (prev * currRes));
                solve(i + 1, s, target, ans, curr + "-" + st, -currRes, res - currRes);
            }
        }

    }
}