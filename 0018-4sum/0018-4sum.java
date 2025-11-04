class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        int n=nums.length;
       if(n<4) return ans;
       
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                Set<Long> set=new HashSet<>();
                 for(int k=j+1;k<n;k++){
                    long sum=(long)nums[i]+(long)nums[j]+(long)nums[k];
                    long fourth=(long)target-sum;
                    if(set.contains(fourth)){
                       List<Integer> quad=Arrays.asList(nums[i],nums[j],nums[k],(int)fourth);
                       Collections.sort(quad);
                       if(!ans.contains(quad)){
                        ans.add(quad);
                       }
                    }
                         set.add((long)nums[k]);
                 }
            }
        }
        return ans;
    }
}