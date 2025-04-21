class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtracking(candidates, target,0,new ArrayList<>(),0,result);
        return result;
    }
    private void backtracking(int[] candidates, int target, int idx, List<Integer> comb, int total,List<List<Integer>> res){
        if(total==target){
            res.add(new ArrayList<>(comb));
            return;
        }
        if(total>target || idx >= candidates.length){
            return;
        }
        comb.add(candidates[idx]);
        backtracking(candidates,target,idx,comb,total+candidates[idx],res);
        comb.remove(comb.size()-1);
        backtracking(candidates,target,idx+1,comb,total,res);
    }
}