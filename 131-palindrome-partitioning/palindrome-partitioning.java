class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        if (s == null || s.isEmpty()) {
            return res;
        }
        solve(s, 0, curr, res);
        return res;
    }

    public void solve(String s, int startidx, List<String> curr, List<List<String>> res) {
        if (s.length() == startidx) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for (int i = startidx; i < s.length(); i++) {
            String sb = s.substring(startidx, i + 1);
            if (isPalindrome(sb)) {
                curr.add(sb);
                solve(s, i + 1, curr, res);
                curr.remove(curr.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}