class Solution {
    public String removeOccurrences(String s, String part) {
        int n = s.length();
        // int m = part.length();
        int[] lps = kmp(part);
        List<Integer> prefixMatch = new ArrayList<>();
        StringBuilder res = new StringBuilder();
        for (char ch : s.toCharArray()) {
            res.append(ch);
            int j = prefixMatch.isEmpty() ? 0 : prefixMatch.get(prefixMatch.size() - 1);
            while (j > 0 && part.charAt(j) != ch) {
                j = lps[j - 1];
            }
            if (part.charAt(j) == ch) {
                j++;
            }
            prefixMatch.add(j);
            if (j == part.length()) {
                res.delete(res.length() - part.length(), res.length());
                for (int k = 0; k < part.length(); k++) {
                    prefixMatch.remove(prefixMatch.size() - 1);
                }
            }
        }
        return res.toString();
    }

    public int[] kmp(String s) {
        int[] lps = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            int prevIdx = lps[i - 1];
            while (prevIdx > 0 && s.charAt(i) != s.charAt(prevIdx)) {
                prevIdx = lps[prevIdx - 1];
            }
            lps[i] = prevIdx + (s.charAt(i) == s.charAt(prevIdx) ? 1 : 0);
        }
        return lps;
    }
}