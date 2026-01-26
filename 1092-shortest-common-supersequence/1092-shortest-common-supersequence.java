class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
      String ans=lcs(str1,str2);
      return ans;
    }
    public String lcs(String str1,String str2){
        //build lcs dp table
        int n=str1.length();
        int m=str2.length();
        int[][] dp=new int[n+1][m+1];
        //initialization
        // if(n==0||m==0) return 0;
        //iteration
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str1.charAt(i-1)==str2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
       //bactrack to find lcs string
       int i=n,j=m;//initialized with last index so backtrack from last cell
       StringBuilder sb=new StringBuilder();
       while(i>0&&j>0){
        if(str1.charAt(i-1)==str2.charAt(j-1)){//matching characters
            sb.append(str1.charAt(i-1));
            i--;
            j--;
        }
        else if(dp[i-1][j]>dp[i][j-1]){//comparing max value in tabble across diagonal
            sb.append(str1.charAt(i-1));
            i--;
        }
        else{
            sb.append(str2.charAt(j-1));
            j--;
        }
       }
       //add remaining characters
       while(i>0){
         sb.append(str1.charAt(i-1));
            i--;
       }
       while(j>0){
        sb.append(str2.charAt(j-1));
            j--;
       }
      return sb.reverse().toString();
    }
}