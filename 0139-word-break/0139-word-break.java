class Solution {
    static Boolean[] dp;
    public boolean wordBreak(String s, List<String> wordDict) {
        dp=new Boolean[s.length()];
        Set<String> set=new HashSet<>(wordDict);
        return helper(s, set, 0);
    }
    private static boolean helper(String s, Set<String> set, int idx){
        int n=s.length();
        if(idx==n)
           return true;
        if(dp[idx]!=null) return dp[idx];
        for(int k=idx+1;k<=n;k++){
            String word=s.substring(idx,k);
            if(set.contains(word) && helper(s, set, k))
               return dp[idx]=true;
        }
        return dp[idx]=false;
    }
}