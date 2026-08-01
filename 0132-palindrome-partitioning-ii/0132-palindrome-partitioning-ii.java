class Solution {
    static int dp[][];
    static boolean[][] pallin;
    public int minCut(String s) {
       int n=s.length();
        dp=new int[n+1][n+1];
        for(int[] row:dp){
          Arrays.fill(row,-1);
        }
        pallin=new boolean[n+1][n+1];
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                if(gap==0) pallin[i][j]=true;
                else if(gap==1) pallin[i][j]=s.charAt(i)==s.charAt(j);
                else{
                  pallin[i][j]=s.charAt(i)==s.charAt(j) && pallin[i+1][j-1];  
                }
            }
        }
      return partition(s,0,s.length()-1);
   }
   
   static int partition(String s,int l,int r){
    
    if(l>r) return 0;
    if(l==r) return 0;
    if(dp[l][r]!=-1) return dp[l][r];
    if(isPallin(s,l,r)) return 0;
    if(pallin[l][r]) return dp[l][r]= 0;
    int min=Integer.MAX_VALUE;
    int left,right=0;
    //find temp ans
    for(int k=l;k<r;k++){
        if(!pallin[l][k]) continue;
        if(dp[l][k]!=-1)
         left=dp[l][k];
        else{
         left=partition(s, l, k);
         dp[l][k]=left;
        }
        if(dp[k+1][r]!=-1)
         right=dp[k+1][r];
        else{
         right=partition(s, k+1, r);
         dp[k+1][r]=right;
        }
       int tempAns=left+right+1;
       min=Math.min(tempAns,min);
    }
    return dp[l][r]=min;
   }
   
  static boolean isPallin(String s,int l,int r){
    // int l=0;
    // int r=s.length()-1;
    if(l>r) return true;
    if(l==r) return true;
    
    while(l<r){
      if(s.charAt(l)!=s.charAt(r))
         return false;
      l++;
      r--;
    }
    return true;
         
    }
}