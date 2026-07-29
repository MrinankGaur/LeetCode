class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.equals("")) return 0;
        Set<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int max = 0;
        while(r<s.length()){
            char c = s.charAt(r);
            if(!set.contains(c)){
                set.add(c);
                r++;
                max = Math.max(max,r-l);
            }else{
                set.remove(s.charAt(l));
                l++;
            }
        }
        return max;
    }
}
