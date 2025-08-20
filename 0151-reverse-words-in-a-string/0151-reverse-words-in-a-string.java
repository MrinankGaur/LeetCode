class Solution {
    public String reverseWords(String s) {
        Stack<String> st = new Stack<>();
        
        String x = "";
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch != ' ') {
                x += ch;
            } else {
                if(!x.isEmpty()){
                    st.push(x);
                    x = ""; 
                }
            }
        }
        if(!x.isEmpty()){
            st.push(x);
        }

        x = "";
        while(!st.isEmpty()){
            x += st.pop();
            if(!st.isEmpty()) x += " ";
        }
        return x;
    }
}
