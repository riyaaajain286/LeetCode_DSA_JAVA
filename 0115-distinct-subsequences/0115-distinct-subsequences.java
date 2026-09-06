class Solution {
    static int[][] dp;
    public int numDistinct(String s, String t) {
        int n=s.length();
        int m=t.length();
        dp=new int[n+1][m+1];
        for(int[] r:dp){
            Arrays.fill(r,-1);
        }
        return subsequences(s,t,n-1,m-1);
    }
    private static int subsequences(String s, String t, int i, int j){
        if(j<0){
            return 1;
        }
               
        if(i<0){
            return 0;
        }
        
        if(dp[i][j]!=-1) return dp[i][j];
        int op1=0,op2=0;
        if(s.charAt(i)==t.charAt(j)){
            op1=subsequences(s,t,i-1,j-1)+subsequences(s,t,i-1,j);
        }
        else{
            op2=subsequences(s,t,i-1,j);
        }
       return dp[i][j]=op1+op2;
        
    }
}