class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ans.add(intervals[0]);
        int j = 0;
        for (int i = 0; i < n; i++) {
            int interval[] = ans.get(j);
            if (intervals[i][0] <= interval[1]) {
                interval[1] = Math.max(intervals[i][1], interval[1]);
            } else {
                ans.add(intervals[i]);
                j++;
            }
        }
        int[][] arr = new int[j + 1][2];
        for (int i = 0; i < j + 1; i++) {
            arr[i] = ans.get(i);
        }
        return arr;
    }
}