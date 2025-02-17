class Solution {
    int m;

    public int numTilePossibilities(String tiles) {
        m = tiles.length();
        HashSet<String> set = new HashSet<>();
        boolean used[] = new boolean[m];
        backtrack(tiles, set, used, "");
        return set.size() - 1;
    }

    public void backtrack(String tiles, HashSet<String> set, boolean used[], String curr) {
        if (set.contains(curr)) {
            return;
        }
        set.add(curr);
        for (int i = 0; i < m; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            backtrack(tiles, set, used, curr + tiles.charAt(i));
            used[i] = false;
        }
    }
}