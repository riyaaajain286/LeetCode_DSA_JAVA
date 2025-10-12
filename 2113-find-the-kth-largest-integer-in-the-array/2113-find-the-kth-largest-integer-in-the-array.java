import java.math.BigInteger;
class Solution {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue <BigInteger> pq=new PriorityQueue<>();
        for(String s:nums){
            BigInteger num=new BigInteger(s);
            pq.add(num); 
           if(pq.size()>k){
            pq.poll();
        }
        }
        // int min=0;
        // for(int i=k;i<nums.length;i++){
        //    min=pq.peek();
        //    if(nums[i]>min){
        //     pq.poll();
        //     pq.add(String.valueOf(nums[i]));
        //    } 
           return pq.peek().toString();
        }
    
}