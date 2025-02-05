class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int n = s1.length();
        // int m = s1.length();
        int count = 0;
        int i = 0;
        int j = 0;
        // if (n != m) {
        // return false;
        // }
        if (s1.equals(s2)) {
            return true;
        }
        for (int p = 0; p < n; p++) {
            if (s1.charAt(p) != s2.charAt(p)) {
                count++;
                if (count > 2) {
                    return false;
                } else {
                    if (count == 1) {
                        i = p;
                    } else {
                        j = p;
                    }
                }
            }
        }
        return (s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i));
    }
}