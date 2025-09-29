class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int n = s.length();
        int len = Integer.MIN_VALUE;
        for(int i =0;i<n;i++){
            String temp = "";
            int[] arr = new int[256];
            for(int j = i;j<n;j++){
                char c = s.charAt(j);
                int it = (int) c;
                if(arr[it]!=0) break;
                arr[it]=1;
                temp+=c;   
            }
            len = Math.max(len,temp.length());
        }
        return len;
    }
}