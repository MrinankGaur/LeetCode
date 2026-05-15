class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int it:nums){
            if(set.contains(it)) return true;
            set.add(it);
        }
        return false;
    }
}