class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n==0){
            return tasks.length;
        }
        int[] map = new int[26];
        for(char ch:tasks){
            int it = ch-'A';
            map[it]++;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->Integer.compare(b.freq,a.freq));
        for(int i = 0;i<26;i++){
            if(map[i]!=0){
                char c = (char)( i + (int)'A');
                pq.offer(new Pair(c,map[i]));
            }
        }
        PriorityQueue<Tuple> waitQ = new PriorityQueue<>((a,b)->Integer.compare(a.time,b.time));
        int currentTime = 0;
        while(!pq.isEmpty() || !waitQ.isEmpty()){
            currentTime++;
            if(pq.peek()!=null){
                Pair curr = pq.poll();
                curr.freq = curr.freq - 1;
                if(curr.freq>0){
                    waitQ.offer(new Tuple(curr.ch, curr.freq, currentTime+n));
                }
            }
            if(!waitQ.isEmpty() && waitQ.peek().time==currentTime){
                Tuple x = waitQ.poll();
                pq.offer(new Pair(x.ch,x.freq));
            }
        }
        return currentTime;
    }
}
class Tuple{
    char ch;
    int freq;
    int time;
    public Tuple(char ch, int freq, int time){
        this.ch = ch;
        this.freq = freq;
        this.time = time;
    }
}
class Pair{
    char ch;
    int freq;
    public Pair(char ch, int freq){
        this.ch = ch;
        this.freq = freq;
    }
}