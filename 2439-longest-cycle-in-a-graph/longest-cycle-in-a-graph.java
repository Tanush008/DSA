class Solution {
    int longestCycle = -1;

    public int longestCycle(int[] edges) {
        int n = edges.length;
        boolean[] visit = new boolean[n];
        boolean[] path = new boolean[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                dfs(edges, visit, path, i, map, 0);
            }
        }
        return longestCycle;
    }

    public void dfs(int[] edges, boolean[] visit, boolean[] path, int node, Map<Integer, Integer> map, int depth) {
        if (visit[node] || node == -1) {
            return;
        }
        visit[node] = true;
        path[node] = true;
        map.put(node, depth);
        int next = edges[node];
        if (next != -1) {
            if (path[next]) {
                longestCycle = Math.max(longestCycle, depth - map.get(next) + 1);
            } else {
                dfs(edges, visit, path, next, map, depth + 1);
            }
        }
        path[node] = false;
    }
}