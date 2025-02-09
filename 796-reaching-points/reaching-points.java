class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy) {
            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
        }
        if (tx == sx && ty >= sy) {
            return (ty - sy) % tx == 0;
        } else if (ty == sy && tx >= sx) {
            return (tx - sx) % ty == 0;
        }
        return false;
    }
}