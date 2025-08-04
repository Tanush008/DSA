class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int max = 0;
        while (j < n) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            int leftFruit = fruits[i];
            if (map.size() <= 2) {
                max = Math.max(max, j - i + 1);
            } else {
                map.put(leftFruit, map.getOrDefault(fruits[i], 0) - 1);
                if (map.get(leftFruit) == 0) {
                    map.remove(leftFruit);
                }
                i++;
            }
            j++;
        }
        return max;
    }
}