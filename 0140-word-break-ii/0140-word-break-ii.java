class Solution {
    Set<String> set=new HashSet<>();
    Map<String,List<String>> memo=new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        set.addAll(wordDict);
        return solve(s);
    }
    private List<String> solve(String s){
        //base case
        if(s.length()==0){
            List<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        //memo check if alrdy computed
        if(memo.containsKey(s))
           return memo.get(s);
        
        List<String> result=new ArrayList<>();
        // Try every prefix
        for(int l=1;l<=s.length();l++){
            String word=s.substring(0,l);
            if(set.contains(word)){
                String rem=s.substring(l);
                List<String> remResult=solve(rem);
            
            for(String sentence:remResult){
                if(sentence.isEmpty())
                 result.add(word);
                else{
                   result.add(word+" "+sentence);
                }
            }
            }
        }
        memo.put(s,result);
        return result;
    }
}