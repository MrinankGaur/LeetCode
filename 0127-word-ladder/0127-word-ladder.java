class Solution {
    class Pair{
        String first;
        int second;
        Pair(String first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> s=new HashSet<>(wordList);
        if (!s.contains(endWord)) return 0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));

        while(!q.isEmpty()){
            Pair curr=q.poll();
            String word=curr.first;
            int step=curr.second;

            char[] wordCharArray=word.toCharArray();
            if(word.equals(endWord)) return step;
            for(int i=0;i<word.length();i++){
                char originalChar=wordCharArray[i];
                for(char ch='a';ch<='z';ch++){
                    if (ch == originalChar) continue;
                    wordCharArray[i]=ch;
                    String newWord=new String(wordCharArray);
                    if(s.contains(newWord)){
                        s.remove(newWord);
                        q.add(new Pair(newWord,step+1));
                    }
                }
                wordCharArray[i] = originalChar;
            }
        }
        return 0;
    }
}