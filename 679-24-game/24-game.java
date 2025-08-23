class Solution {
    public boolean judgePoint24(int[] cards) {
        List<Double> list = new ArrayList<>();
        for(int card:cards){
            list.add((double)card);
        }
        return solve(list);
    }

    public boolean solve(List<Double> list) {
        // List<Integer>list=new ArrayList<>(cards);
        if (list.size() == 1) {
            return Math.abs(list.get(0) - 24.0) < 1e-6;
        }
        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                List<Double> nxt = new ArrayList<>();
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) {
                        nxt.add(list.get(k));
                    }
                }
                double a = list.get(i);
                double b = list.get(j);
                List<Double> res = new ArrayList<>();
                res.add(a + b);
                res.add(b - a);
                res.add(a - b);
                if (Math.abs(a) > 0.0) {
                    res.add(b / a);
                }
                if (Math.abs(b) > 1.0) {
                    res.add(a / b);
                }
                res.add(a*b);
                for (double val : res) {
                    nxt.add(val);
                    if (solve(nxt)) {
                        return true;
                    }
                    nxt.remove(nxt.size() - 1);
                }
            }
        }
        return false;
    }
}