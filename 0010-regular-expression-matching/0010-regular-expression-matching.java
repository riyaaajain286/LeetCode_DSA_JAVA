class Solution {
    //MEMOIZATION
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
         int m=p.length();
         int n=s.length();
         dp=new Boolean[n+1][m+1];
        return solve(s,p,0,0);
    }
    private boolean solve(String s, String p, int i, int j){
        int n=s.length();
        int m=p.length();
        //base cases

        // Both string and pattern finished
        if(i>=n && j>=m){
            return true;
        }
         // Pattern finished
        if(j==m) return i==n;
         
         //memoization
        if(dp[i][j]!=null)
           return dp[i][j];
       
        //recursion hypothesis
        // Check current character match
        boolean match=i<n && (s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
        
        // Check FIRST whether current pattern character
        // is followed by '*'
        // If next character is '*'
        if(j+1<m && p.charAt(j+1)=='*'){
            // Don't take current character*
            boolean dont_take=solve(s,p,i,j+2);
            // Take current character if it matches
            boolean take=match && solve(s,p,i+1,j);
            dp[i][j]=dont_take || take;
        }
             
         // Normal character matching
        else if(match)
           dp[i][j]=solve(s,p,i+1,j+1);
        
        // No match
        else {
           dp[i][j] = false;
        }
       
        return dp[i][j];
       }
}