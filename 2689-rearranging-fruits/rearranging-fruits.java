class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;
        int m = basket2.length;
        long minCost = 0;
        int minEl = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        // Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(basket1[i], map.getOrDefault(basket1[i], 0) + 1);
            minEl = Math.min(minEl, basket1[i]);
        }
        for (int j = 0; j < m; j++) {
            map.put(basket2[j], map.getOrDefault(basket2[j], 0) - 1);
            minEl = Math.min(minEl, basket2[j]);
        }
        List<Integer> finalList = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int cost = entry.getKey();
            int count = entry.getValue();
            if (count == 0) {
                continue;
            }
            if (count % 2 != 0) {
                return -1;
            }
            for (int i = 1; i <= Math.abs(count) / 2; i++) {
                finalList.add(cost);
            }
        }
        Collections.sort(finalList);
        for (int i = 0; i < finalList.size() / 2; i++) {
            minCost += Math.min(finalList.get(i), minEl * 2);
        }
        return minCost;
    }

}