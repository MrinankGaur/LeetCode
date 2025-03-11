class Solution {
    public boolean isPalindrome(String s) {
        String x = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");
        
        return helper(x,0,(x.length()-1));

    }
    public boolean helper(String x,int start,int end){
        if(start>=end){
            return true;
        }
        if(x.charAt(start)!=x.charAt(end)){
            return false;
        }
        
        return true && helper(x,++start,--end);
    }
}