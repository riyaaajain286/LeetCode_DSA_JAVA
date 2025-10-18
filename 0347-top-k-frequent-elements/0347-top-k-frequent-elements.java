class Solution {
  class Pair{
    int number;
    int freq;
    public Pair(int number,int freq){
    this.number=number;
    this.freq=freq;
  }
  }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqmap=new HashMap<>();
        for(int n:nums){
        freqmap.put(n,freqmap.getOrDefault(n,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->b.freq-a.freq);
        for(Map.Entry<Integer,Integer> entry:freqmap.entrySet()){
        pq.add(new Pair(entry.getKey(),entry.getValue()));
        }
        int res[]=new int[k];
        for(int i=0;i<k;i++){
        res[i]=pq.poll().number;
        }
    return res;
}
  }
