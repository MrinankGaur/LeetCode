class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        for(char ch:tasks){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(b.freq,a.freq));
        for(Map.Entry<Character,Integer> entry:map.entrySet()){
            pq.offer(new Pair(entry.getKey(),entry.getValue()));
        }
        int time = 0;
        Queue<Tuple> q = new LinkedList<>();
        while(!pq.isEmpty() || !q.isEmpty()){
            time++;
            if(!pq.isEmpty()){
                Pair curr = pq.poll();
                char task = curr.task;
                int freq = curr.freq-1;
                if(freq>0){
                    q.offer(new Tuple(task,freq,time+n));
                }
            }
            if(!q.isEmpty() && q.peek().time == time){
                Tuple curr1 = q.poll();
                pq.offer(new Pair(curr1.task,curr1.freq));
            }
        }
        return time;
    }
    class Tuple{
        char task;
        int freq;
        int time;
        public Tuple(char task,int freq,int time){
            this.task = task;
            this.freq = freq;
            this.time = time;
        }
        
    }
    class Pair{
        char task;
        int freq;
        public Pair(char task,int freq){
            this.task = task;
            this.freq = freq;
        }
    }
}