class Solution {
    //memoization
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        dp=new int[n+1][m+1];
        return helper(word1,word2,n,m);
    }
    public int helper(String a, String b,int i,int j){
        //base case
        if(i==0) return j;
        if(j==0) return i;
        // memo check
        if(dp[i][j]!=0) return dp[i][j];
        //string matching
        if(a.charAt(i-1)==b.charAt(j-1)) 
        dp[i][j]=0+helper(a,b,i-1,j-1);
        else{
         dp[i][j]=1+Math.min(Math.min(helper(a,b,i,j-1), //insert
            helper(a,b,i-1,j)),//delete
            helper(a,b,i-1,j-1));//replace
        }
       return dp[i][j]; 
    }
}