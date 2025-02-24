class Solution {
    public int reverse(int y) {
        int x = (y>=0)?y:-y;
        long sum = 0;

        while(x>0){
            int digit = x%10;
            x = x/10;
            sum = sum*10 + digit;
            
        }
        sum=(y>=0)?sum:-sum;
        if(sum>Integer.MAX_VALUE || sum<Integer.MIN_VALUE){
            return 0;
        }
        return (int)sum;
    }
}