class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        path+='/';
        String str = "";
        for(char ch: path.toCharArray()){
            if(ch == '/'){
                if(str.equals("..")){
                    if(!st.isEmpty()) st.pop();
                }
                else if(!str.equals("") && !str.equals(".")){
                    st.push(str);
                }
                str = "";
            }else{
                str += ch;
            }
        }

        return "/" + String.join("/", st);
    }
}