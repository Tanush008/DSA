class Solution {
    public int findCenter(int[][] edges) {
        int pair[] = edges[0];
        int pair1[] = edges[1];
        if (pair[0] == pair1[0] || pair[0] == pair1[1]) {
            return pair[0];
        } else {
            return pair[1];
        }
    }
}