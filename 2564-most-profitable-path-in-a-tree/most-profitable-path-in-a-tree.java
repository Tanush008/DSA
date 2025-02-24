class Solution {
    HashMap<Integer, Integer> bobMap = new HashMap<>();
    HashMap<Integer, List<Integer>> adj = new HashMap<>();
    int aliceIncome;

    public int mostProfitablePath(int[][] edges, int bob, int[] amount) {
        // List<List<Integer>> list = new ArrayList<>();
        aliceIncome = Integer.MIN_VALUE;
        int n = amount.length;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }
        int time = 0;
        boolean[] visit = new boolean[n];
        dfs(bob, time, visit);
        int income = 0;
        Arrays.fill(visit, false);
        dfsAlice(0, 0, income, visit, amount);
        return aliceIncome;
    }

    public boolean dfs(int curr, int time, boolean[] visit) {
        visit[curr] = true;
        bobMap.put(curr,time);
        if (curr == 0) {
            return true;
        }

        for (int i : adj.getOrDefault(curr, new ArrayList<>())) {
            if (!visit[i]) {
                if (dfs(i, time + 1, visit)) {
                    return true;
                }
            }
        }
        bobMap.remove(curr);
        return false;
    }

    public void dfsAlice(int curr, int time, int income, boolean visit[], int amt[]) {
        visit[curr] = true;
        if (!bobMap.containsKey(curr) || time < bobMap.get(curr)) {
            income += amt[curr];
        } else if (time == bobMap.get(curr)) {
            income += (amt[curr] / 2);
        }
        if (adj.getOrDefault(curr, new ArrayList<>()).size() == 1 && curr != 0) {
            aliceIncome = Math.max(aliceIncome, income);
        }

        for (int i : adj.getOrDefault(curr, new ArrayList<>())) {
            if (!visit[i]) {
                dfsAlice(i, time + 1, income, visit, amt);
            }
        }
    }
}