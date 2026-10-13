class Solution {
    static Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp=new Boolean[s.length()];
        return helper(s, wordDict, 0);
    }
    private static boolean helper(String s, List<String> wordDict, int idx){
        int n=s.length();
        if(idx==n)
           return true;
        if(dp[idx]!=null) return dp[idx];
        for(int k=idx+1;k<=n;k++){
            String word=s.substring(idx,k);
            if(wordDict.contains(word) && helper(s, wordDict, k))
               return dp[idx]=true;
        }
        return dp[idx]=false;
    }
}