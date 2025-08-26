class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        f(ans,temp,0,s);
        return ans;
    }
    public void f(List<List<String>> ans,List<String> temp,int i,String x){
        if(i==x.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int index = i;index<x.length();index++){
            if(isPalindrome(x,i,index)){
                temp.add(x.substring(i,index+1));
                f(ans,temp,index+1,x);
                temp.remove(temp.size()-1);
            }
        }
    }


    public boolean isPalindrome(String str,int start,int end){
        if(start>=end) return true;
        if(str.charAt(start)!=str.charAt(end)){
            return false;
        }
        return true && isPalindrome(str,start+1,end-1);
    }
}