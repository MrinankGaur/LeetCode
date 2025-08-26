class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        f(ans,0,0,n,new StringBuilder());
        return ans;
    }
    public void f(List<String> ans,int open,int close,int n,StringBuilder s){
        if(s.length()==2*n){
            ans.add(s.toString());
            return;
        }
        if(open<n){
            s.append('(');
            f(ans,open+1,close,n,s);
            s.deleteCharAt(s.length()-1);
        }if(close<open){
            s.append(')');
            f(ans,open,close+1,n,s);
            s.deleteCharAt(s.length()-1);
        }
    }
}