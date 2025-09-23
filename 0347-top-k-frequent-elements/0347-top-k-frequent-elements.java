class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        ArrayList<Integer>[] bucket = new ArrayList[nums.length+1];
        for(int key : map.keySet()){
            int freq = map.get(key);
            if(bucket[freq]==null){
                bucket[freq] = new ArrayList<>();
            }
            bucket[freq].add(key);
        }
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = nums.length;i>=0 && result.size()<k;i--){
            if(bucket[i]!=null) result.addAll(bucket[i]);
        }
        int[] ans = new int[k];
        for(int i = 0;i<k;i++){
            ans[i] = result.get(i);
        }
        return ans;
    }

}
public class Pair{
    int n,freq;
    public Pair(int n,int freq){
        this.n = n;
        this.freq = freq;
    }
}