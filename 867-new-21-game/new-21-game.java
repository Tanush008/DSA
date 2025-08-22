class Solution {
    public double new21Game(int n, int k, int maxPts) {
        double[] probSum = new double[n+1];
        double currSum = (k == 0) ? 0.0 : 1.0;
        probSum[0] = 1.0;
        for (int i = 1; i <=n; i++) {
            probSum[i] = currSum / maxPts;
            if (i < k) {
                currSum += probSum[i];
            }
            if (i - maxPts >= 0 && i - maxPts < k) {
                currSum -= probSum[i - maxPts];
            }
        }
        double res = 0.0;
        for (int i = k; i<=n; i++) {
            res += probSum[i];
        }
        return res;
    }
}