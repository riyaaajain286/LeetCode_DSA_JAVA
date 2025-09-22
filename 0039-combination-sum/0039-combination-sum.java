class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        combination(candidates,target,0,ans,new ArrayList<>());
        return ans;
    }
    public void combination(int[] candidates, int target,int index,List<List<Integer>> ans,   List<Integer>list){
        if(index==candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }
            if(candidates[index]<=target){
                list.add(candidates[index]);
                combination(candidates,target-candidates[index],index,ans,list);
                list.remove(list.size()-1);
            }
            combination(candidates,target,index+1,ans,list);
        }
    }
