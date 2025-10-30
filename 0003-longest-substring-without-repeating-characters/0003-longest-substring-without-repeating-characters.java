class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int[] lastIndex = new int[128];
        Arrays.fill(lastIndex,-1);
        int max = 0;
        for(int end=0; end<s.length(); end++){
            char c = s.charAt(end);
            if(lastIndex[c] >= start) start = lastIndex[c] + 1;
            lastIndex[c] = end;
            if(end - start + 1 > max) max = end - start + 1;
        }
        return max;
    }
}