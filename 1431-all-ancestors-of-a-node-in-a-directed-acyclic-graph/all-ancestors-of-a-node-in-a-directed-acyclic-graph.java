class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> res = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        ArrayList<TreeSet<Integer>> set = new ArrayList<>();
        int indegree[] = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            res.add(new ArrayList<>());
            set.add(new TreeSet<>());

        }
        for (int edge[] : edges) {
            int from = edge[0];
            int to = edge[1];
            indegree[to]++;
            adj.get(from).add(to);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int topSort[] = new int[n];
        int indx = 0;
        while (!queue.isEmpty()) {
            int val = queue.poll();
            topSort[indx] = val;
            indx++;
            for (int node : adj.get(val)) {
                indegree[node]--;
                if (indegree[node] == 0) {
                    queue.offer(node);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            int node = topSort[i];
            for (int neigh : adj.get(node)) {
                set.get(neigh).add(node);
                set.get(neigh).addAll(set.get(node));
            }
        }
        for (int i = 0; i < n; i++) {
            for (int val : set.get(i)) {
                res.get(i).add(val);
            }
        }
        return res;
    }
}