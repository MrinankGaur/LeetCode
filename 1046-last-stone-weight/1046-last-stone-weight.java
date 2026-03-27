class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x,y)->Integer.compare(y,x));
        for(int stone:stones){
            pq.offer(stone);
        }
        while(pq.size()>1){
            int first = pq.poll();
            int second = pq.poll();
            if(first==second) continue;
            pq.offer(first-second);    
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
