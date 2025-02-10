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
                if(stack.isEmpty()){
                    return false;
                }
                char x = stack.pop();
                if((i==')' && x=='(')||(i=='}' && x=='{')||(i==']' && x=='[')){
                    continue;
                }
                else{
                    return false;
                } 
            }
        }
       
       return stack.isEmpty();
    }
}