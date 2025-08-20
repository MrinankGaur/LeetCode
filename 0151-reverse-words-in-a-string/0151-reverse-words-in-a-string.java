class Solution {
    public String reverseWords(String s) {
        StringBuilder result=new StringBuilder();
        String tr=s.trim();
        String [] arr=tr.split("\\s+");
        for(int i=arr.length-1;i>=0;i--){
            result.append(arr[i]);
            if(i>0){
                result.append(" ");
            }
        }
        String result1=result.toString();
        return result1;
    }
}