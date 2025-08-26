class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if(!set.contains(endWord)) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));
        while(!q.isEmpty()){
            Pair curr =  q.poll();
            String word = curr.str;
            int step = curr.step;
            if(word.equals(endWord)) return step;
            char[] arr = word.toCharArray();
            for(int i = 0;i<arr.length;i++){
                char w = arr[i];
                for(char ch = 'a';ch <= 'z'; ch++){
                    if(ch==w) continue;
                    arr[i] = ch;
                    String newWord = new String(arr);
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        q.offer(new Pair(newWord,step+1));
                    }
                }
                arr[i] = w;
            }
        }
        return 0;
    }

    public class Pair{
        String str;
        int step;
        public Pair(String str, int step){
            this.str = str;
            this.step = step;
        }
    }
}