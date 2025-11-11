class Solution {
    class Pair{
        String word;
        int steps;
        public Pair(String word,int steps){
            this.word=word;
            this.steps=steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set=new HashSet<>(wordList);
        if(!set.contains(endWord))  return 0;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(beginWord,1));
        while(!q.isEmpty()){
            Pair p=q.poll();
            String word=p.word;
            int step=p.steps;
            if(word.equals(endWord))  return step;
            char[] arr=word.toCharArray();
            for(int i=0;i<word.length();i++){
                char original=arr[i];
                for(char c='a';c<='z';c++){
                    arr[i]=c;
                    String newword=new String(arr);
                    if(set.contains(newword)){
                        q.add(new Pair(newword,step+1));
                        set.remove(newword);
                    }
                }
                arr[i]=original;
            }
        }
        return 0;
    }
}