class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n=nums.length;
        int c1=0,c2=0;
        int e1=Integer.MIN_VALUE;
        int e2=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            if(c1==0&&e2!=nums[i]){
                c1++;
                e1=nums[i];
            }
            else if(c2==0&&e1!=nums[i]){
                c2++;
                e2=nums[i];
            }
            else if(nums[i]==e1){
                c1++;
            }
            else if(nums[i]==e2){
                c2++;
            }
            else{
                c1--;
                c2--;
            }
        }
    c1=0;
    c2=0;
    ArrayList<Integer> anslist=new ArrayList<>();
    for(int i=0;i<n;i++){
     if(nums[i]==e1){
        c1++;
     }
     else if(nums[i]==e2){
        c2++;
     }
    }
     int ans=((int)n/3)+1;
     if(c1>=ans){
        anslist.add(e1);
     }
      if(c2>=ans){
        anslist.add(e2);
     }
     return anslist;
    }
    

}