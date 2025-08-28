class Solution {
    public String removeOuterParentheses(String s) {
        String ns = "";
        int cnt = 0;
        String tmp = "";
        for(char c: s.toCharArray()){
            if(c == '('){
                cnt++;
            } else {
                cnt--;
            }
            if(cnt == 0){
                ns += tmp.substring(1);
                tmp = "";
            } else {
                tmp += c;
            }
        }
        return ns;
    }
}