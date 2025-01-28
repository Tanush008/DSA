class Solution {
    public String validIPAddress(String queryIP) {
        if (queryIP.length() == 0) {
            return "Neither";
        }
        if (queryIP.contains(".")) {
            return ipv4(queryIP);
        }
        if (queryIP.contains(":")) {
            return ipv6(queryIP);
        }
        return "Neither";
    }

    public String ipv4(String queryIP) {
        if (queryIP.charAt(0) == '.' || queryIP.charAt(queryIP.length() - 1) == '.') {
            return "Neither";
        }
        String[] segement = queryIP.split("\\.");
        if (segement.length != 4) {
            return "Neither";
        }
        for (String s : segement) {
            if (s.length() == 0 || s.length() > 3 || (s.length() > 1 && s.charAt(0) == '0')) {
                return "Neither";
            }
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                    return "Neither";
                }
            }
            if (Integer.valueOf(s) > 255) {
                return "Neither";
            }
        }
        return "IPv4";
    }

    public String ipv6(String queryIP) {
        if (queryIP.charAt(0) == ':' || queryIP.charAt(queryIP.length() - 1) == ':') {
            return "Neither";
        }
        String[] segement = queryIP.split(":");
        if (segement.length != 8) {
            return "Neither";
        }
        for (String s : segement) {
            if (s.length()==0 || s.length() > 4) {
                return "Neither";
            }

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (!(c >= '0' && c <= '9') && !(c >= 'a' && c <= 'f') && !(c >= 'A' && c <= 'F')) {
                    return "Neither";
                }
            } 
        }
        return "IPv6";
    }
}