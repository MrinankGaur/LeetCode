import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> map = new HashMap<>();
        for (char c : tasks) {
            map.put(c, map.getOrDefault(c, 0) + 1);          
        }


        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        Queue<PairCooldown> cooldown = new LinkedList<>();
        int time = 0;

        while (!pq.isEmpty() || !cooldown.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                Pair curr = pq.poll();
                curr.freq--;
                if (curr.freq > 0) {
                    cooldown.offer(new PairCooldown(curr, time + n));
                }
            }

            if (!cooldown.isEmpty() && cooldown.peek().readyTime == time) {
                pq.offer(cooldown.poll().pair);
            }
        }

        return time;
    }

    class Pair {
        char task;
        int freq;
        public Pair(char task, int freq) {
            this.task = task;
            this.freq = freq;
        }
    }

    class PairCooldown {
        Pair pair;
        int readyTime;
        public PairCooldown(Pair pair, int readyTime) {
            this.pair = pair;
            this.readyTime = readyTime;
        }
    }
}