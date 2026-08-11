class Solution {
    //move based approach
    public int superEggDrop(int k, int n) {
        int moves=0;
        int[] dp=new int[k+1];
        while(dp[k]<n){
            moves++;
            //dp[e] = floors we can cover with e eggs using previous moves
            //Given eggs + moves=Find maximum floors
            //each time we try to find that with given eggs and increaing moves how many floors can we cover that is by the last index of dp i.e. dp[k]
            for(int eggs=k;eggs>=1;eggs--){
               dp[eggs]=dp[eggs-1]+1+dp[eggs];
            }
        }
        return moves;
    }
}