class Solution {

    public int findShortestCycle(int n, int[][] edges) {
        int shortestCycle = Integer.MAX_VALUE;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        for (int start = 0; start < n; start++) {
            int[] depth = new int[n];
            Arrays.fill(depth, -1);
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] { start, -1 });
            depth[start] = 0;
            while (!queue.isEmpty()) {
                int[] curr = queue.poll();
                int node = curr[0];
                int parent = curr[1];
                for (int next : adj.get(node)) {
                    if (depth[next] == -1) {
                        depth[next] = depth[node] + 1;
                        queue.offer(new int[] { next, node });
                    } else if (next != parent) {
                        shortestCycle = Math.min(shortestCycle, depth[node] + depth[next] + 1);
                    }
                }
            }
        }
        return (shortestCycle == Integer.MAX_VALUE) ? -1 : shortestCycle;
    }
}