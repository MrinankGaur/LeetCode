class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int l=0,r=0;
        int max =Integer.MIN_VALUE;
        HashMap<Integer,Integer> map = new HashMap<>();

        while(r<n){
            map.put(fruits[r],map.getOrDefault(fruits[r],0)+1);
            while(map.size()>2){
                map.put(fruits[l],map.get(fruits[l])-1);
                if(map.get(fruits[l])==0){
                    map.remove(fruits[l]);
                }
                l++;
            }
            max = Math.max(max,r-l+1);
            r++;
        }
        // for(int i = 0;i<n;i++){
        //     HashSet<Integer> set = new HashSet<>();
        //     int x = 0;
        //     for(int j = i;j<n;j++){
        //         set.add(fruits[j]);
        //         if(set.size()>2) break;
        //         x++;
        //     }
        //     max = Math.max(x,max);
        // }
        return max;
    }
}