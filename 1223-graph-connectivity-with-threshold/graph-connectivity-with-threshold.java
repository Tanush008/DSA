class Solution {
    int[] rank;
    int[] component;
    int distinctComp;

    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        // int len = queries.length;
        component = new int[n + 1];
        rank = new int[n + 1];
        distinctComp = n;
        for (int i = 0; i <= n; i++) {
            component[i] = i;
            rank[i] = 0;
        }
        for (int i = threshold + 1; i <= n; i++) {
            int m = 1;
            while (i * m <= n) {
                unite(i, i * m);
                m++;
            }
        }
        List<Boolean> l = new ArrayList<>();
        for (int[] q : queries) {
            l.add(connected(q[0], q[1]));
        }
        return l;
    }

    public boolean unite(int a, int b) {
        int x = findComponent(a);
        int y = findComponent(b);
        if (x != y) {
            if (rank[x] < rank[y]) {
                component[x] = y;
            } else if (rank[x] > rank[y]) {
                component[y] = x;
            } else {
                component[y] = x;
                rank[x]++;
            }
            distinctComp--;
            return true;
        } else {
            return false;
        }
    }

    public int findComponent(int a) {
        if (component[a] != a) {
            component[a] = findComponent(component[a]);
        }
        return component[a];
    }

    public boolean connected(int a, int b) {
        int x = findComponent(a);
        int y = findComponent(b);
        return x == y;
    }

    // public boolean united() {
    //     return distinctComp == 1;
    // }
}