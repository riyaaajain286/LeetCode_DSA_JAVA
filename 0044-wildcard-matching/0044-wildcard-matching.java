class Solution {
    static Boolean dp[][]; 
    public boolean isMatch(String s, String p) {
        int n=s.length();
        int m=p.length();
        dp=new Boolean[n+1][m+1];
        return solve(s, p, 0, 0);

}
private static boolean solve(String s,String p,int i,int j){
    int n=s.length();
    int m=p.length();
  //base case
    
        if(i>=n && j>=m){
          return true;
        }
        if(i>=n ){
          for(int k=j;k<m;k++){
              if(p.charAt(k)!='*') return false;
              
          }
          return true;
        }
        if(j>=m) return false;
        if(dp[i][j]!=null) return dp[i][j];
     //hypothesis  
       if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?'){
          dp[i][j]=solve(s,p,i+1,j+1);
        }
        else if(p.charAt(j)=='*'){
          dp[i][j]=solve(s,p,i+1,j) || solve(s,p,i,j+1);
        }
        else{
          dp[i][j]=false;
        }
    return dp[i][j];
   }
}