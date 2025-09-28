class Solution {
    public List<List<Integer>> permute(int[] nums) {
         List<List<Integer>> ans=new ArrayList<>();
         boolean[] freq=new boolean[nums.length];
         helper(nums,ans,new ArrayList<>(),freq);
         return ans;
    }
    public void helper(int[] nums,List<List<Integer>> ans,List<Integer> list,boolean[] freq){
        if(list.size()==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!freq[i]){
                freq[i]=true;
                list.add(nums[i]);
                helper(nums,ans,list,freq);
                list.remove(list.size()-1);
                freq[i]=false;
            }
        }
    }
}