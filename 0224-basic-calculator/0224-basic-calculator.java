class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int n = s.length();
        int ans = 0;
        int num = 0;
        int sign = 1;
        for(int i = 0;i<n;i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10 + (c-'0');
            }
            else if(c == '+' || c == '-'){
               ans+=num*sign;
               num = 0;
               sign = (c=='-')?-1:1; 
            }
            else if(c=='('){
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            }
            else if(c==')'){
                ans+=num*sign;
                ans*=stack.pop();
                ans+=stack.pop();
                num=0;
            }
        }
        ans+=num*sign;
        return ans;
    }
}