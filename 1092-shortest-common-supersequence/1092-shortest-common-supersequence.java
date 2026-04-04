class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        return lcsB(str1,str2);
    }
    public static String lcsB(String text1, String text2){
        int n=text1.length();
        int m=text2.length();
       int[][] dp=new int[n+1][m+1];
       for(int i=0;i<=n;i++){
        for(int j=0;j<=m;j++){
            if(i==0||j==0){
                dp[i][j]=0;
            }
        }
    }
     //iteration
       for(int i=1;i<=n;i++){
        for(int j=1;j<=m;j++){
         if(text1.charAt(i-1)==text2.charAt(j-1)){
            dp[i][j]= 1+dp[i-1][j-1];
        }
        else{
            dp[i][j]= Math.max(dp[i][j-1],dp[i-1][j]);
        }
          }
       }
       int i=n,j=m;
       StringBuilder sb=new StringBuilder();
       while(i>0 && j>0){
        if(text1.charAt(i-1)==text2.charAt(j-1)){
            sb.append(text1.charAt(i-1));
            i--;
            j--;
        }
        else if(dp[i-1][j]>dp[i][j-1]){
            sb.append(text1.charAt(i-1));
            i--;
        }
        else{
            sb.append(text2.charAt(j-1));
            j--;
        }
    }
    //add remaining
    while(i>0){
        sb.append(text1.charAt(i-1));
        i--;
    }
     while(j>0){
        sb.append(text2.charAt(j-1));
        j--;
    }
    sb.reverse();
    String rev=sb.toString();
    return rev;
    }
}