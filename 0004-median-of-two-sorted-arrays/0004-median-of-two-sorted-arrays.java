class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
         int n=nums1.length;
        int m=nums2.length;
        int[] com=new int[n+m];
        for(int i=0;i<n;i++){
            com[i]=nums1[i];
        }
        for(int j=0;j<m;j++){
            com[n+j]=nums2[j];
        }
        Arrays.sort(com);
        int c=com.length;
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