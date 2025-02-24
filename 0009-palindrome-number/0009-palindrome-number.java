class Solution {
    public boolean isPalindrome(int y) {
        if(y<0){
            return false;
        }
        int x = y;
        int sum = 0;

        while (x != 0) {
            int rem = x % 10;
            sum = sum * 10 + rem;
            x = x / 10;
        }
        return y==sum;
    }
}
