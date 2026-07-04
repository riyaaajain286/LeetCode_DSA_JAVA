class Solution {
    // BS ON ANSWER
    public int smallestDivisor(int[] nums, int threshold) {
        //always start checking divisor from 1 therefore min=1
        int max=Integer.MIN_VALUE;
        for(int i:nums){
            max=Math.max(i,max);
        }
        int n=nums.length;
        int start=1,end=max;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(isPossible(nums,threshold,mid)){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }

        }
        return ans;
    }
    private boolean isPossible(int[] nums,int threshold,int divisor){
        int sum=0;
        // for(int i:nums){
        //     // sum+=(i+divisor-1)/divisor;
        //     //doing this coz before ceil runs If both i and divisor are int, Java performs integer division first.decimal part is already lost before Math.ceil() runs
        //     sum+=(int)Math.ceil((double)i/divisor);//Instead, force floating-point division:
        // }
        //other solution
        for(int i:nums){
            sum+=i/divisor;
            if(i % divisor!=0){
                sum++;
            }
        }
        return sum<=threshold;
    }
}