class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int l=0;
        int r=k-1;
        int avg=0;
        int sum=0;
        int n=nums.length;
        for(int i=l;i<=r;i++){
            sum+=nums[i];
        }
        int max=sum;//max should initialize from 1st window sum coz array can contain -ve no.s 
           while(r<n-1){             //otherwise will return 
             sum-=nums[l];
             l++;
             r++;
             sum+=nums[r];
        max=Math.max(sum,max);
            }
            max=Math.max(max,sum);
       
return (double)max/k;

    }
}