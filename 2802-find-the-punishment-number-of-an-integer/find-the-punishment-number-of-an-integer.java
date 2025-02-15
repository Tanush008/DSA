class Solution {
    public int punishmentNumber(int n) {
        int totalSum = 0;
        for (int i = 1; i <= n; i++) {
            int sq = i * i;
            String square = String.valueOf(sq);
            if (partition(square, 0, i)) {
                totalSum += sq;
            }
        }
        return totalSum;
    }

    boolean partition(String s, int idx, int targetSum) {
        if (s.length() == idx) {
            return targetSum == 0;
        }
        int sum = 0;
        for (int i = idx; i < s.length(); i++) {
            char ch = s.charAt(i);
            sum = sum * 10 + (ch - '0');
            if (sum > targetSum) {
                break;
            }
            if (partition(s, i+1, targetSum - sum)) {
                return true;
            }
        }
        return false;
    }
}