class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen = Integer.MIN_VALUE;
        int l = 0,r=0;
        int[] map = new int[26];
        int maxFreq = 0;
        while(r<n){
            char c = s.charAt(r);
            map[c-'A']++;
            maxFreq = Math.max(maxFreq,map[c-'A']);
            int len = r-l+1;
            int replacement = len-maxFreq;
            if(replacement<=k){
                maxLen = Math.max(len,maxLen);
            }
            else{
                map[s.charAt(l)-'A']--;
                l++;
            }
            r++;
        }
        return maxLen;
    }
}