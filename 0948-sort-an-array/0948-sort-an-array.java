class Solution {
    public int[] sortArray(int[] nums) {
    int n=nums.length;
    buildmaxheap(nums,n);
    for(int i=n-1;i>0;i--){
   swap(nums,0,i);
   heapify(nums,0,i);
  
  }
   return nums;
    }
      public  static void heapify(int[] nums,int i,int n){
  int largest=i;
  int left=i*2+1;
  int right=i*2+2;
  if(left<n&&nums[left]>nums[largest]){
    largest=left;
  }
  if(right<n&&nums[right]>nums[largest]){
   largest=right;
  }
  if(largest!=i){
    int temp=nums[i];
  nums[i]=nums[largest];
  nums[largest]=temp;
  heapify(nums, largest, n);
  }
}
private   static void buildmaxheap(int[]nums,int n){
  for(int i=(n/2)-1;i>=0;i--){
    heapify(nums,i,n);
  }
}
public static void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

}
}