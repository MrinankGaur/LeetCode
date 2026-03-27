class KthLargest {
    PriorityQueue<Integer> pq;
    private int k;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;
        for(int it:nums){
            pq.offer(it);
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        while(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }
}
