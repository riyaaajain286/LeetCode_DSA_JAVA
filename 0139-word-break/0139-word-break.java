class Solution {
    //Memoization
    static Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp=new Boolean[s.length()];
        //by converting to set it reduces complexity for searching word in dict
        Set<String> dict=new HashSet<>(wordDict);
        return  solve(s,dict,0);
    }
    private static  boolean solve(String s, Set<String> dict,int idx){
        int n=s.length();
        //base case
        if(idx==n){
            return true;//all words found and reached end of s
        }
        if(dp[idx]!=null) return dp[idx];
        for(int k=idx+1;k<=n;k++){
            String word=s.substring(idx,k);
            if(dict.contains(word) && solve(s,dict,k)){
                return dp[idx]=true;//after findig valid answer,return immediately
            }
        }
        return dp[idx]=false;
    }
}