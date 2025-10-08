class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int n = s.length();
        int l =0,r=0;
        int count = 0;
        while(r<n){
            char c = s.charAt(r);
            map.put(c,r);
            int min = Integer.MAX_VALUE;
            if(map.size()==3){
                for(Map.Entry<Character,Integer> entry : map.entrySet()){
                    min = Math.min(min,entry.getValue());
                }
                count += min-l+1;        
            }
            
            r++;
        }
        return count;

    }
}