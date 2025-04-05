class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, candidate = 0;

        // Step 1: Find potential candidate
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
                
                count = 1;
                
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
            System.out.println("cand: "+candidate+" count: "+ count);
        }

        // Step 2: Verify candidate
        count = 0;
        for (int num : nums) {
            if (num == candidate) count++;
        }

        return (count > nums.length / 2) ? candidate : -1;
    }
}
