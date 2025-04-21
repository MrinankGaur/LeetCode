class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int ans;
        int n = tokens.length;
        for(int i = 0;i<n;i++){
            String x = tokens[i];
            if(x.equals("*")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a*b);
            }
            else if(x.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push((int)(b/a));

            }
            else if(x.equals("-")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a);

            }
            else if(x.equals("+")){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(a+b);
            }
            else{
                stack.push(Integer.parseInt(x));
            }
        }
        return stack.pop();
    }
}