class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int sum=0;
        int[] minLenTillIdx=new int[arr.length];
        Arrays.fill(minLenTillIdx,Integer.MAX_VALUE);
        int bestMinLen=Integer.MAX_VALUE;
        int result=Integer.MAX_VALUE;
        int l=0,r=0;
        while(r<arr.length){
        sum+=arr[r];
        /// Shrink window if sum becomes greater than target
        while(sum>target){
            sum-=arr[l];
            l++;
        }
        if(sum==target){
            int len=r-l+1;
            // Check for a previous non-overlapping subarray
            if(l>0 && minLenTillIdx[l-1]!=Integer.MAX_VALUE ){
            result=Math.min(len+minLenTillIdx[l-1],result);
            }
            // Store the minimum length found so far
            bestMinLen=Math.min(bestMinLen,len);
        }
        // Carry forward the best answer till index r
        minLenTillIdx[r]=bestMinLen;
        r++;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}