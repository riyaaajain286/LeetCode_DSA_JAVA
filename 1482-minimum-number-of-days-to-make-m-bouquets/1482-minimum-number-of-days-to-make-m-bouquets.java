class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // Not enough flowers
        if((long)m*k>bloomDay.length) return -1;
        int low=Integer.MAX_VALUE;
        int high=Integer.MIN_VALUE;
        for(int b:bloomDay){
            low=Math.min(b,low);
            high=Math.max(b,high);
        }
        int ans=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(bloomDay,m,k,mid)){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    private boolean isPossible(int[] bloomDay, int m, int k,int maxTime){
        int flowers=0,bouquets=0;
        for(int b:bloomDay){
            if(b<=maxTime){
                flowers++;
                if(flowers==k){
                    bouquets++;
                    flowers=0;// Start counting for the next bouquet
                }
            }
            else{
                flowers=0;// Consecutive flowers break
            }
        }
        return bouquets>=m;
    }
}