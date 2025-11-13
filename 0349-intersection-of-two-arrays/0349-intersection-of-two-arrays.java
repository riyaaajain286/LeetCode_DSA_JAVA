class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int m=nums1.length;
        int n=nums2.length;
        int i=0;
        int j=0;
        int k=0;
        int[] ans=new int[Math.min(m,n)];
        while(i<m&&j<n){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }
            else{
                if(k==0||ans[k-1]!=nums1[i])
                  ans[k++]=nums1[i];
             i++;
             j++;
            }
        }
        return Arrays.copyOf(ans,k);
    }
}