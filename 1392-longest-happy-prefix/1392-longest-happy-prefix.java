class Solution {
    public String longestPrefix(String s) {
        String ans = "";
        for(int i = 1;i<s.length();i++){
            String x = s.substring(0,i);
            if(s.endsWith(x)){
                ans = x;
                System.out.println(x);
            }
        }
        return ans;
    }
}