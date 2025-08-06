class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String newS = generate(s);
            if (!map.containsKey(newS)) {
                map.put(newS, new ArrayList<>());
            }
            map.get(newS).add(s);
        }
        return new ArrayList<>(map.values());
    }

    public String generate(String word) {
        int[] alpha = new int[26];
        StringBuilder sb = new StringBuilder();
        for (char ch : word.toCharArray()) {
            alpha[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (alpha[i] > 0) {
                sb.append(String.valueOf((char) (i + 'a')).repeat(alpha[i]));
            }
        }
        return sb.toString();
    }
}