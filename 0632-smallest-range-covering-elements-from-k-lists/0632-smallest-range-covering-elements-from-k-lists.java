class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
    class Pair<F,S>{
    F first;
    S second;
    public Pair(F first,S second){
      this.first=first;
      this.second=second;
    }}
    PriorityQueue<Pair<Integer,Pair<Integer,Integer>>> pq=new PriorityQueue<>((a,b) -> a.first-b.first);
 
    int max=Integer.MIN_VALUE;
    for(int i=0;i<nums.size();i++){
      int val=nums.get(i).get(0);
      pq.add(new Pair<>(val,new Pair<>(i,0)));
      max=Math.max(max,val);
    }
      
    int min=pq.peek().first;
     int[] range={min,max};
    
    while(pq.size()==nums.size()){
      Pair<Integer,Pair<Integer,Integer>> topmostpair=pq.poll();
      min=topmostpair.first;
      int row=topmostpair.second.first;
      int col=topmostpair.second.second;
      // update range
      if(max-min<range[1]-range[0]){// if current range smaller than update
            range[0]=min;
            range[1]=max;
      }
      //now move to next element in same row
      if(col+1<nums.get(row).size()){
        int nextval=nums.get(row).get(col+1);
        pq.add(new Pair<>(nextval,new Pair<>(row,col+1)));
        max=Math.max(max,nextval);
      }
      else{
        //one list exhausted-stop
        break;
      }
    }
    return range;
    }
}