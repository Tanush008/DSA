class Solution {
    public String clearDigits(String s) {
        int n = s.length();
        // Stack<Character> st = new Stack<>();
        StringBuilder sb  = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (!Character.isDigit(s.charAt(i))) {
                // st.push(s.charAt(i));
                sb.append(s.charAt(i));
            } else {
                if (sb.length()!=0) {
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        // StringBuilder sb = new StringBuilder();
        // while(!st.isEmpty()){
        //     sb.insert(0,st.pop());
        // }
        return sb.toString();
    }
}