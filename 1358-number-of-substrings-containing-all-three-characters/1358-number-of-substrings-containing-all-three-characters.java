import java.util.Arrays;
class Solution {
    public int numberOfSubstrings(String s) {
        int[] last = {-1 , -1 , -1}; int cnt = 0;

        for(int i=0; i<s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
            cnt = cnt + (1 + Math.min(Math.min(last[0] , last[1]) , last[2])) ;
        }
        return cnt;
    }
}