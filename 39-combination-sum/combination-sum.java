class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        // int[][] dp = new int[n][target + 1];
        // for (int[] i : dp) {
        // Arrays.fill(i, -1);
        // }
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        recu(candidates, 0, target, res, curr);
        return res;
    }

    public void recu(int[]candi,int index,int target,List<List<Integer>>res,List<Integer>curr){
        if(index==candi.length){
            if(target==0){
               res.add(new ArrayList<Integer>(curr));
            }
            return;
        }
        // if(dp[candi][target]!=-1){
        //     return dp[candi][target];
        // }
        // int pick = 0;
        if(target>=candi[index]){
            curr.add(candi[index]);
            recu(candi,index,target-candi[index],res,curr);
            curr.remove(curr.size()-1);
        }
         recu(candi,index+1,target,res,curr);
    }
}