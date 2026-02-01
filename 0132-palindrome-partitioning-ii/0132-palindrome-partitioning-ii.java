class Solution {
    static int[][] dp;
    static boolean pal[][];
    public int minCut(String s) {
        int n=s.length();
        dp=new int[n][n];
        pal=new boolean[n][n];
        //initialize dp
        for(int i=0;i<n;i++){
         for(int j=0;j<n;j++){
          dp[i][j]=-1;
        }
      }
      //precompute pallindromes in o(n^2)
      for(int gap=0;gap<n;gap++){
        for(int i=0, j=gap;j<n;i++,j++){
            if(gap==0)//substring length=1
             pal[i][j]=true;
            else if(gap==1 )//substring length=2
             pal[i][j]=s.charAt(i)==s.charAt(j);
            else
              pal[i][j]=s.charAt(i)==s.charAt(j) && pal[i+1][j-1];

        }
      }
        int ans=solve(s,0,n-1);
        return ans;
    }
public static int  solve(String s,int i,int j){
    int n=s.length();
   
    //base condition
    if(i>=j){//means no string if i>j and i==j means single letter so no partition
      return 0;
    }
    // if substring is palindrome check in o(1)
    if(pal[i][j]){
      return 0;
    }
    //memo check
    if(dp[i][j]!=-1){
      return dp[i][j];
    }
    int min=Integer.MAX_VALUE;
    //k loop
    for(int k=i;k<j;k++){
        //pruning
        if(!pal[i][k])
         continue;
        int leftans,rightans;
        //left check
         if(dp[i][k]!=-1){
            leftans=dp[i][k];
         }
         else{
            leftans=solve(s,i,k);
            dp[i][k]=leftans;
         }
         //right check
            if(dp[k+1][j]!=-1){
             rightans=dp[k+1][j];
         }
         else{
            rightans=solve(s,k+1,j);
            dp[k+1][j]=rightans;
         }
        int tempans=1+leftans+rightans;
        if(tempans<min){
            min=tempans;
        }
    }
    dp[i][j]=min;
    return dp[i][j];
  }
//   public static boolean isPallin(String s,int i,int j){
//     if(i==j){//only one letter alwz pallindrome
//       return true;
//     }
//     if(i>j){//empty string
//       return true;
//     }
//     while(i<j){
//       if(s.charAt(i)!=s.charAt(j)){
//         return false;
//       }
//       i++;
//       j--;
      
//     }
//     return true;
//   }
}