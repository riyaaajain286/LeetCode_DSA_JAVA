class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        CombinationSum(0, candidates, target, ans, new ArrayList<>());
        return ans;
    }

    private static void CombinationSum(int index,int[] arr,int target,  List<List<Integer>> ans,ArrayList<Integer> list){

        //target reached
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        //no more elements
        if(index==arr.length)
            return;

        //take
        if(arr[index]<=target){
            
            list.add(arr[index]);
            //stay at same index
            CombinationSum(index, arr, target-arr[index], ans, list);
            //backtrack
            list.remove(list.size()-1);
        }
        //not take
            CombinationSum(index+1, arr, target, ans, list);
        
  }
}