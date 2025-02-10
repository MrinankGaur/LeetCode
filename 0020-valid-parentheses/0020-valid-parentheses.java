class Solution {
    public boolean isValid(String s) {
       Stack<Character> stack = new Stack<Character>();
       if(s.length()==1){
        return false;
        }
       for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='('){
            stack.push(s.charAt(i));
            continue;
        }
        if(!stack.isEmpty()){
            if(s.charAt(i)=='}' && stack.peek()!='{'){
            return false;
        }else if(s.charAt(i)=='}' && stack.peek()=='{'){
            stack.pop();
        }
        if(s.charAt(i)==']' && stack.peek()!='['){
            return false;
        }else if(s.charAt(i)==']' && stack.peek()=='['){
            stack.pop();
        }
        if(s.charAt(i)==')' && stack.peek()!='('){
            return false;
        }else if(s.charAt(i)==')' && stack.peek()=='('){
            stack.pop();
        }

        }else{
            return false;
        }
       }
       if(stack.isEmpty()){
        return true;
       }
       return false;
    }
}