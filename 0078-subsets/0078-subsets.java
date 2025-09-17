class Solution {
    List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
       helper(nums,0,new ArrayList<>());
       return res;
    }
    public void helper(int[] nums,int i,List<Integer> sublist){
        if(i==nums.length){
            res.add(new ArrayList<>(sublist));
            return;
        }
        //pick
        sublist.add(nums[i]);
        helper(nums,i+1,sublist);
        //while backtracking we need to remove the last added index
        sublist.remove(sublist.size()-1);
        //not pick
        helper(nums,i+1,sublist);
        //since we have not addded any element so no need to remove while backtracking
    }
}