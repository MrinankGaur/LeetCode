class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->Integer.compare(y.freq,x.freq));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
        }
        int[] ans = new int[k];
        for(int i = 0;i<k;i++){
            Pair curr = pq.poll();
            ans[i] = curr.n;
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