class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int[] com=new int[n+m];
        int i=0,j=0,k=0;
        //merge step of merge sort
        while(i<n && j<m){
            if(nums1[i]<nums2[j])
             com[k++]=nums1[i++];
            else
             com[k++]=nums2[j++];
        }
        while(i<n){
           com[k++]=nums1[i++]; 
        }
        while(j<m){
            com[k++]=nums2[j++];
        }
        int c=n+m;
        int s=0;
        int e=c-1;
        if(c%2==1){//odd
           int mid=c/2;
           return com[mid];
        }
        else{
           int mid1=com[c/2];
           int mid2=com[(c/2)-1];
           double ans=(mid1+mid2)/2.0;
           return ans;
        }
      
    }
}