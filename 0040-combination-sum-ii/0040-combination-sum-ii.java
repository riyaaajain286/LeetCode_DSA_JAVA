class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates,target,0,new ArrayList<>(),ans);
        return ans;
    }

    private static void helper(int[] arr,int target,int index,List<Integer> list,List<List<Integer>> ans){
     if(target==0){
      ans.add(new ArrayList<>(list));
      return;
     }
     if(index==arr.length){
      return;
     }
     //duplicate check
     for(int i=index;i<arr.length;i++){
       // Skip duplicates at the same level
        if(i>index && arr[i]==arr[i-1])
           continue;
          // Since array is sorted
        if(arr[i]>target)
         break;
        //take
        list.add(arr[i]);
          // Move to next index
        helper(arr,target-arr[i],i+1,list,ans);
        //backtrack
        list.remove(list.size()-1);
     }
    }
}