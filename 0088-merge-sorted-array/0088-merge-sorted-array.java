class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
         int first=m-1;
        int second=0;
        while(first>=0&&second<n){
            if(nums1[first]>nums2[second]){
                swap(nums1,nums2,first,second);
                first--;
                second++;
            }
            else
            {
                break;
            }
        }
        int k=0;
        for(int x=m;x<m+n;x++){
            nums1[x]=nums2[k];
            k++;
        }
        Arrays.sort(nums1);
        // Arrays.sort(nums2);
    }
    public static  void swap(int nums1[],int nums2[],int first,int second){
        int temp=nums1[first];
        nums1[first]=nums2[second];
        nums2[second]=temp;
    }
    }
