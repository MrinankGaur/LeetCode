class Solution {
    public int rob(int[] num) {
        int n = num.length;
        if (n == 1) {
            return num[0];
        }
        if (n == 2) {
            return Math.max(num[0], num[1]);
        }
        int prev2 = num[0];
        int prev1 = Math.max(num[0], num[1]);
        int curr = prev1;
        for (int i = 2; i < n; i++) {
            curr = Math.max(num[i] +prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
    }
}
