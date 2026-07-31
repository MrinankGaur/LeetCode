class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if(n1>n2) return false;
        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for(int i = 0;i<n1;i++){
            map1[s1.charAt(i)-'a']++;
            map2[s2.charAt(i)-'a']++;
        }
        if(equal(map1,map2,26)) return true;
        for(int i = n1;i<n2;i++){
            map2[s2.charAt(i)-'a']++;
            map2[s2.charAt(i-n1)-'a']--;
            if(equal(map1,map2,26)) return true;
        }
        return equal(map1,map2,26);

    }
    public boolean equal(int[] arr1,int[] arr2,int n){
        for(int i =0;i<n;i++){
            if(arr1[i]!=arr2[i]) return false;
        }
        return true;
    }
}