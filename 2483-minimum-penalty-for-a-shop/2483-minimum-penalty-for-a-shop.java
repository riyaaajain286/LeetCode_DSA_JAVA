class Solution {
    public int bestClosingTime(String customers) {
        int n=customers.length();
        int[] prefix=new int[n+1];
        int[] suffix=new int[n+1];
        //prefix sum when shop is open
         for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]+(customers.charAt(i-1)=='N'?1:0);

         }
         for(int j=n-1;j>=0;j--){
            suffix[j]=suffix[j+1]+(customers.charAt(j)=='Y'?1:0);
         }
         int minPenalty=Integer.MAX_VALUE;
         int ct=0;
         // Try all closing hours
         for(int i=0;i<=n;i++){
            int penalty=prefix[i]+suffix[i];
            if(penalty<minPenalty){
                minPenalty=penalty;
                ct=i;
            }
         }
        return ct;
    }
}