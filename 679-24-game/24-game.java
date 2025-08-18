class Solution {
    public boolean judgePoint24(int[] cards) {
        // int n = card.length;
        List<Double> list = new ArrayList<>();
        for (int card : cards) {
            list.add((double) card);
        }
        return solve(list);
    }

    public boolean solve(List<Double> num) {
        if (num.size() == 1) {
            return Math.abs(num.get(0) - 24.0) < 1e-6;
        }
        int n = num.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                List<Double> next = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        next.add(num.get(k));
                    }
                }
                double a = num.get(i), b = num.get(j);
                List<Double> res = new ArrayList<>();
                res.add(a + b);
                res.add(a - b);
                res.add(b - a);
                res.add(a * b);
                if (Math.abs(b) > 1e-6) {
                    res.add(a / b);
                }
                if (Math.abs(a) > 1e-6) {
                    res.add(b / a);
                }
                for (double val : res) {
                    next.add(val);
                    if (solve(next))
                        return true;
                    next.remove(next.size() - 1);
                }
            }
        }
        return false;
    }
}