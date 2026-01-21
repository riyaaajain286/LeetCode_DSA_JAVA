class Solution {
    public int countKDifference(int[] nums, int k) {
        // Map<Integer,Integer> map=new HashMap<>();
        int[] freq=new int[101];//constraint
        //count freq of each  no
        for(int i:nums){
            freq[i]++;
        }
        int c=0;
        for(int i=1;i+k<=100;i++){
            c+=freq[i]*freq[i+k];
        }
        return c;
    }
}