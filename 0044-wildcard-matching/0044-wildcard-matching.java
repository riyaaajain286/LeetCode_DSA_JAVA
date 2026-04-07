class Solution {
    //memoization
    Boolean[][] dp;
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        dp=new Boolean[n+1][m+1];
       
        return solve(s,p,0,0);
    }
    public boolean solve(String s, String p,int i,int j) {
      int n=s.length();
      int m=p.length();
       //memo check
      if(dp[i][j]!=null) return dp[i][j];
      //base case
      if(i>=n && j>=m){// all char r matcehd
        return true;
      }
      if(j>=m){//s remains so not matched
        return false;
      }
      if(i>=n){//check for all remmianing j iff all r * thrn they can be matched will null 
           for(int k=j;k<m;k++){
            if(p.charAt(k)!='*') return false;
           }
        return true;
      }
     
      //hypothesis
      boolean ans=false;
      if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
          ans=solve(s,p,i+1,j+1);
      }
      else if(p.charAt(j)=='*'){
        ans=solve(s,p,i+1,j)||solve(s,p,i,j+1); 
      }
      else{
        return false;
      }
      return dp[i][j]=ans;
    }

    
}