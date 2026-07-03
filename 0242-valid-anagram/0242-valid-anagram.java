class Solution {
    public boolean isAnagram(String s, String t) {
        int[] map = new int[26];
        for(char ch:s.toCharArray()){
            map[ch-'a']++;
        }
        for(char ch:t.toCharArray()){
            map[ch-'a']--;
        }
        for(int it:map){
            if(it!=0) return false;
        }
        return true;

    }
}
