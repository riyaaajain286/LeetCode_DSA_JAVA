class Solution {
    public int findKthLargest(int[] nums, int k) {
    int min=0;
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    for(int i=0;i<k;i++){
      pq.add(nums[i]);
    }
    for(int i=k;i<nums.length;i++){
      min=pq.peek();
      if(nums[i]>min){
        pq.poll();
        pq.add(nums[i]);
      }
    }
    return pq.peek();
    }
}