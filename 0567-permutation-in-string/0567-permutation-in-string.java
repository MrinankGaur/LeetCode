class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = s1.length();
        int n = s2.length();
        if(l>n) return false;
        int[] map1 = new int[26];
        for(char ch:s1.toCharArray()){
            map1[ch-'a']++;
        }
        for(int i =0;i<=n-l;i++){
            int[] map2 = new int[26];
            for(int j = i;j<i+l;j++){
                char ch = s2.charAt(j);
                map2[ch-'a']++;
            }
            if(matches(map1,map2,26)) return true;
            
        }
        return false;
        
    }
    public boolean matches(int[] arr1, int[] arr2, int n){
        for(int i=0;i<n;i++){
            if(arr1[i]!=arr2[i]) return false;
        }
        return true;
    }
}