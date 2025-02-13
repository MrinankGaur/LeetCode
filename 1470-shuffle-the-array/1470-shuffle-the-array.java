class Solution {
    public int[] shuffle(int[] nums, int n) {
        int f = 0;
        int s = n;
        int[] arr = new int[nums.length];
        for(int i =0;i<nums.length;i++){
            if(i%2==0){
                arr[i]=nums[f++];
            }else{
                arr[i]=nums[s++];
            }
        }
        return arr;
    }
}