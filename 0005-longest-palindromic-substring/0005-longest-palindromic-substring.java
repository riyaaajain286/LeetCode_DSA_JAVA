class Solution {
    int[][] dp;
    public String longestPalindrome(String s) {
        int n=s.length();
        dp=new int[n+1][n+1];
        for(int[] r:dp)
          Arrays.fill(r,-1);
        int sp=0;
        int maxlen=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
              if(solve(s,i,j)==1){
                if(j-i+1>maxlen){
                    maxlen=j-i+1;
                    sp=i;
                }
             }
            }
        }
        return s.substring(sp,sp+maxlen);
    }
    private int solve(String s,int i,int j){
        if(i>=j) return 1;
        if(dp[i][j]!=-1) return dp[i][j];
        if(s.charAt(i)==s.charAt(j)){
            return dp[i][j]= solve(s,i+1,j-1);

        }
        else{
            return dp[i][j]=0;
        }
    }
}