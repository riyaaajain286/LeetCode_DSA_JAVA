class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
       int arr[][] =new int[m+1][n+1];
 //first row and first col will be 0 coz if len is 0 for any row or col then no lcs i.e. nothing common so ret 0
    for(int row=0;row<=m;row++){
    arr[row][0]=0;
    } 
    for(int col=0;col<=n;col++){
    arr[0][col]=0;
    } 
    for(int i=1;i<=m;i++){
        for(int j=1;j<=n;j++){
            if(text1.charAt(i-1)==text2.charAt(j-1)){
                arr[i][j]=1+arr[i-1][j-1];
            }
            else{
                arr[i][j]=Math.max(arr[i][j-1],arr[i-1][j]);
            }
        }
    }
    return arr[m][n];
    }
}