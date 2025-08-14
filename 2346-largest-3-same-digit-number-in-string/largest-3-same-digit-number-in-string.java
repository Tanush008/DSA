class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        if (n < 3) {
            return "";
        }
        String res = "";
        for (int i = 0; i <= n - 3; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                String triple = num.substring(i, i + 3);
                if (res.isEmpty() || triple.compareTo(res) > 0) {
                    res = triple;
                }
            }
        }
        return res;
    }
}