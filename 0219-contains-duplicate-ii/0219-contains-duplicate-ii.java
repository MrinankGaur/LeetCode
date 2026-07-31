class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int l = 0;
        set.add(nums[l]);
        for(int r=1;r<nums.length;r++){
            if(r-l>k){
                set.remove(nums[l++]);
            }
            if(set.contains(nums[r])){
                return true;
            }
            set.add(nums[r]);
        }
        return false;
    }
}