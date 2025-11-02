class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
      List<List<Integer>> ans=new ArrayList<>();
      int n=nums.length;
      Set<Integer> set;
      Arrays.sort(nums);
      for(int i=0;i<n;i++){
        if(i>0&&nums[i]==nums[i-1]) continue;
        Set<Integer> middle=new HashSet<>();
        for(int j=i+1;j<n;j++){
            int complement=-(nums[i]+nums[j]);
            if(middle.contains(complement)){
                List<Integer> triplet=Arrays.asList(nums[i],nums[j],complement);
                Collections.sort(triplet);
                ans.add(triplet);
            }
            middle.add(nums[j]);
        }
      }
    
    return ans;
}
}