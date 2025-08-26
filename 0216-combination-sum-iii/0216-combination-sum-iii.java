class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list,new ArrayList<>(),k,n,1);
        return list;
    }
    public void helper(List<List<Integer>> ans, List<Integer> temp,int k,int n, int start){
        if(temp.size()==k && n==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (temp.size() > k || n < 0) return;
        for(int i=start;i<=9;i++){
            temp.add(i);
            helper(ans,temp,k,n-i,i+1);
            temp.remove(temp.size()-1);
        }
    }
}