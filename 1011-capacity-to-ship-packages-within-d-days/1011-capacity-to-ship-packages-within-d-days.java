class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int ans=0;
        int n=weights.length;
        int low=0,high=0;
        for(int i=0;i<n;i++){
            low=Math.max(low,weights[i]);
            high+=weights[i];
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isPossible(weights,mid,days)){//left
                ans=mid;
                high=mid-1;

            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
    private boolean isPossible(int[] weights,int maxAllowedTime,int days){
        int requiredDays=1;
        int sum=0;
        int n=weights.length;
        for(int i=0;i<n;i++){
            
            if(sum+weights[i]<=maxAllowedTime){
                sum+=weights[i];
            }
            else{
                requiredDays++;
                sum=weights[i];
            }
        }
        return requiredDays<=days;
    }
}