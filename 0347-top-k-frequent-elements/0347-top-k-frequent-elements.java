class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    Map<Integer,Integer> freqmap=new HashMap<>();
    for(int n:nums){
      freqmap.put(n,freqmap.getOrDefault(n,0)+1);
    }
       List<Integer>[] buckets=new ArrayList[nums.length+1];
    for(int key:freqmap.keySet()){
      int c=freqmap.get(key);
      if(buckets[c]==null){
      buckets[c]=new ArrayList<>();
      }
      buckets[c].add(key);
    }
    int[] res=new int[k];
    int idx=0;
    for(int i=nums.length;i>=0&&idx<k;i--){
      if(buckets[i]!=null){
        for(int num:buckets[i]){
        res[idx++]=num;
        if(idx==k) break;
        }
      } 
    }

  return res;
    }
}