class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String str : tokens){
            if(str.equals("+")){
                st.push(st.pop()+st.pop());
            }
            else if(str.equals("/")){
                int a = st.pop();
                int b = st.pop();
                st.push(b / a);
            }
            else if(str.equals("-")){
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            }
            else if(str.equals("*")){
                st.push(st.pop()*st.pop());
            }
            else{
                st.push(Integer.parseInt(str));
            }
        }
        return st.pop();
    }
}
