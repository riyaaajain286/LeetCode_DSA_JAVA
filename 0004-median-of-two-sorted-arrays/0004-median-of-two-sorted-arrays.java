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
        if(c%2!=0){//odd
           int mid=s+(e-s)/2;
           return (double)(com[mid]);
        }
        else{
           int mid=s+(e-s)/2; 
           double ans=(double)(com[mid]+com[mid+1])/2;
           return ans;
        }
      
    }
}