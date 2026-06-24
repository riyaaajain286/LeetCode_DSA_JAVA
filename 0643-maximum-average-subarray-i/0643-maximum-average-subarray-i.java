class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        int i=0;
        double sum=0;
        for(int j=0;j<k;j++){
            sum+=nums[j];
        }
        double maxsum=sum;
        
        for(int j=k;j<n;j++){
            sum+=nums[j];
            sum-=nums[i];
            i++;
            
            if(sum>maxsum){
                maxsum=sum;
                
            }
        }
        return (double)(maxsum/k);
    }
}