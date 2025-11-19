class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int first=m;
        int second=0;
        while(first<nums1.length&&second<nums2.length){
            nums1[first]=nums2[second];
            first++;
            second++;
        }
        Arrays.sort(nums1);
    }
}