class Solution {
     public int missingNumber(int[] nums) {
        boolean[] arr = new boolean[nums.length+1];
        Arrays.fill(arr, false);
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]] = true;
        }
        int i=0;
        for (i = 0; i < arr.length; i++) {
            if(arr[i]==false)
                break;
        }
        return i;
    }
}