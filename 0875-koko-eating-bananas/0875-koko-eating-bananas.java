class Solution {
    //in this answer lies in range therefore use BS on answer
    public int minEatingSpeed(int[] piles, int h) {
        int s=1;
        int e=0;
        for(int p:piles){
            e=Math.max(e,p);
        }
        int ans=e;
        while(s<=e){
            int mid=s+(e-s)/2;
            long totalhr=calcHours(piles,mid);
            if(totalhr<=h){
                ans=mid;
                e=mid-1;
            }
            else s=mid+1;
        }
        return ans;
    }
    private long calcHours(int[] piles,int hr){
        
         long total=0;
        for(int p:piles){
            //formula for ceil
          total+=(p+hr-1)/hr;
        }
        
        return total;
    }
}