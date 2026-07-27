class Solution {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        for(int it:nums){
            set.add(it);
            max = Math.max(it,max);
        };
        if(max<=0) return 1;
        for(int i = 1;i<max;i++){
            if(!set.contains(i)) return i;
        }
            
        return max+1;

    }
}