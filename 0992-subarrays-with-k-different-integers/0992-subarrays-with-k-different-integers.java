class Solution {
    //sliding window atMostK approach coz i needs EXACTLY k distinct
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums,k)-atMostK(nums,k-1);
    }
    private int atMostK(int[] nums, int k){
        int l=0;
        int result=0;
        int n=nums.length;
        Map<Integer,Integer> map=new HashMap<>();
        for(int r=0;r<n;r++){
           map.put(nums[r],map.getOrDefault(nums[r],0)+1);
           while(map.size()>k){
               map.put(nums[l],map.get(nums[l])-1);
               if(map.get(nums[l])==0)
                  map.remove(nums[l]);
               l++;
           }
           result+=r-l+1;
        }
        return result;
    }
}