class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0)=='0') return 0;
        int n = s.length();
        int prev1 = 1;
        int prev2 = s.charAt(0)=='0'?0:1;
        for(int i = 2;i<=n;i++){
            int dp = 0;
            int oneDigit = s.charAt(i - 1) - '0';
            int twoDigit = (s.charAt(i - 2) - '0') * 10 + oneDigit;
            if(oneDigit>=1){
                dp += prev1;
            }
            if(twoDigit>=10 && twoDigit<=26){
                dp += prev2;
            }
            prev2 = prev1;
            prev1 = dp;
        }
        return prev1;

    }
}