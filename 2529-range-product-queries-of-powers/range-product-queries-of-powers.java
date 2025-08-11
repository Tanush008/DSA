class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int MOD = (int)(1e9+7);
        int m = queries.length;
        int []ans = new int[m];
        List<Integer>power = new ArrayList<>();
        for(int i = 0;i<31;i++){
            if((n>>i&1)==1){
                power.add(1<<i);
            }
        }
        for(int i = 0;i<m;i++){
            int left = queries[i][0];
            int right = queries[i][1];
            long prd = 1;
            for(int j = left;j<=right;j++){
                prd = (prd*power.get(j))%MOD;
            }
            ans[i]=(int)(prd);
        }
        return ans;
    }
}