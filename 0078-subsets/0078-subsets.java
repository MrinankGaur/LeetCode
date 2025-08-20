class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> sub = new ArrayList<>();
        subsetRec(nums,sub,0,res);
        return res;
    }
    public void subsetRec(int[] nums,List<Integer> sub,int index,List<List<Integer>> res){
        if(index == nums.length){
            res.add(new ArrayList<>(sub));
            return;
        }
        sub.add(nums[index]);
        subsetRec(nums,sub,index+1,res);
        sub.remove(sub.size() - 1);
        subsetRec(nums,sub,index+1,res);
    }
}