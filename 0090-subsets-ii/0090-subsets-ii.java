class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
          findsubsets(nums,0,new ArrayList<>(),ans);
          return ans;
    }
    public void findsubsets(int[] arr,int ind,List<Integer> list,List<List<Integer>> ans){
        ans.add(new ArrayList<>(list));
        for(int i=ind;i<arr.length;i++){
            if(i!=ind&&arr[i]==arr[i-1]){
                continue;
            }
            list.add(arr[i]);
            findsubsets(arr,i+1,list,ans);
        
            list.remove(list.size()-1);
        }
        
        }
    }
