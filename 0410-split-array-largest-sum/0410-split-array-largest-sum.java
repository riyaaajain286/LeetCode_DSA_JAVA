class Solution {
    public int splitArray(int[] nums, int k) {
      int st=0,end=0;
      for(int n:nums){
        st=Math.max(st,n);
        end+=n;
      }
      int ans=0;
      while(st<=end){
        int mid=st+(end-st)/2;
        if(isPossible(nums,k,mid)){//search left for better min ans
          ans=mid;
          end=mid-1;
        }
        else{
          st=mid+1;
        }
      }
      return ans;
    }

    public static boolean isPossible(int[] arr,int m,int maxSum){
    int n=arr.length;
    int sum=0,subarrays=1;
      for(int i=0;i<n;i++){
        if(sum+arr[i]<=maxSum){
          sum+=arr[i];
        }
        else{
          subarrays++;
          sum=arr[i];
        }
      }
      return subarrays<=m;
   }
}