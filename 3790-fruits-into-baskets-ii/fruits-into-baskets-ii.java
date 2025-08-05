class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int m = baskets.length;
        int count = 0;
        boolean[] use = new boolean[m];
        for (int i = 0; i < n; i++) {
            boolean place = false;
            for (int j = 0; j < m; j++) {
                if (!use[j] && baskets[j] >= fruits[i]) {
                    use[j] = true;
                    place = true;
                    break;
                }
            }
            if (!place) {
                count++;
            }
        }
        return count;
    }
}