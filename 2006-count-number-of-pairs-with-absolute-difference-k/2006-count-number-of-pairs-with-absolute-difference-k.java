class Solution {
    public int countKDifference(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int c=0;
        // create map
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        //count valid pairs
        for(int key:map.keySet()){
            c+=map.get(key)*map.getOrDefault(key+k,0);
        }
      return c;
    }
}