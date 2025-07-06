class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();    
        int left = 0;
        int maxLeng = 0;
        for (int right = 0; right < n; right++) {
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.get(ch) > 1) {
                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }
            maxLeng = Math.max(maxLeng, right - left + 1);
        }
        return maxLeng;
    }
}