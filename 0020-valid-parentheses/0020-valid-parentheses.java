class Solution {
    public boolean isValid(String s) {
       Stack<Character> stack = new Stack<Character>();
       if(s.length()==1){
        return false;
        }
       for(char i:s.toCharArray()){
        if(i=='(' || i=='[' || i=='{'){
            stack.push(i);
        }
        else{
            if(stack.isEmpty())return false;
            char x = stack.pop();
            if((i==')' && x=='(')||(i=='}' && x=='{')||(i==']' && x=='['))continue;
            else return false;

        }
        // if(s.charAt(i)=='{' || s.charAt(i)=='[' || s.charAt(i)=='('){
        //     stack.push(s.charAt(i));
        //     continue;
        // }
        // if(!stack.isEmpty()){
        //     if(s.charAt(i)=='}' && stack.peek()!='{'){
        //         return false;
        //     }else if(s.charAt(i)=='}' && stack.peek()=='{'){
        //         stack.pop();
        //     }
        //     if(s.charAt(i)==']' && stack.peek()!='['){
        //         return false;
        //     }else if(s.charAt(i)==']' && stack.peek()=='['){
        //         stack.pop();
        //     }
        //     if(s.charAt(i)==')' && stack.peek()!='('){
        //         return false;
        //     }else if(s.charAt(i)==')' && stack.peek()=='('){
        //         stack.pop();
        //     }

        // }else{
        //     return false;
        }
       
       return stack.isEmpty();
    }
}