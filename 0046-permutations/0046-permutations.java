class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> outer=new ArrayList<>();
    return helper(nums,0,outer);
    }
    public static List<List<Integer>> helper(int[]nums,int ind,List<List<Integer>> outer){
     List<Integer> inner=new ArrayList<>();
     if(ind>=nums.length){
      for(int i=0;i<nums.length;i++){
        inner.add(nums[i]);
      }
      outer.add(inner);
     return outer;
     }
     for(int i=ind;i<nums.length;i++){
      swap(nums,i,ind);
      helper(nums,ind+1,outer);
      swap(nums,i,ind);
     }
       return outer;
  }

  
  public static void swap(int[] nums,int first,int second){
    int temp=nums[first];
    nums[first]=nums[second];
    nums[second]=temp;
  }
}