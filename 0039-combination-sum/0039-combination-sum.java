class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        f(0,target,ans,temp,candidates);
        return ans;
    }
    public void f(int i,int target,List<List<Integer>> ans,ArrayList<Integer> temp,int[] arr){
        if(i==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(arr[i]<=target){
            temp.add(arr[i]);
            f(i,target-arr[i],ans,temp,arr);
            temp.remove(temp.size()-1);
        }
        f(i+1,target,ans,temp,arr);
    }
}