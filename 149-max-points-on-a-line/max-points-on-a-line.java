class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        // int m = points[1].length;
        int res = 0;
        if (n == 1) {
            return 1;
        }
        for (int i = 0; i <n; i++) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (j == i) {
                    continue;
                }
                double dx = points[j][0] - points[i][0];
                double dy = points[j][1] - points[i][1];
                double theta = Math.atan2(dy, dx);
                map.put(theta, map.getOrDefault(theta, 0) + 1);
            }
            for (int it : map.values()) {
                res = Math.max(res, it + 1);
            }
        }
        return res;
    }
}