class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int x = (int)Math.pow(2,n)-1;
        for(int i = 0;i<=x;i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0;j<n;j++){
                int y = 1<<j;
                int a = y&i;
                if(a!=0){
                    list.add(nums[j]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
    
}