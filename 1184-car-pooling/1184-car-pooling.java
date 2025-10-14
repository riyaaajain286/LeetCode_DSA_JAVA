class Solution {
    class Pair<F,S>{
    F drop;
    S pass;
    public Pair(F drop,S pass){
      this.drop=drop;
      this.pass=pass;
    }
  }
  class Trip{
    int pass,from,to;
    public Trip(int pass,int from,int to){
      this.pass=pass;
      this.from=from;
      this.to=to;
    }
  }
    public boolean carPooling(int[][] trips, int capacity) {
        //convert to trip objects
   List<Trip> triplist=new ArrayList<>();
   for(int[] t:trips){
    triplist.add(new Trip(t[0],t[1],t[2]));
   }
   //sort trips via from location
   triplist.sort((a,b)->a.from-b.from);
   //minheap based on drop location
   PriorityQueue<Pair<Integer,Integer>> pq=new PriorityQueue<>((a,b)->a.drop-b.drop);
   int curpass=0;
   //process trips
   for(Trip trip:triplist){
    while(!pq.isEmpty()&&pq.peek().drop<=trip.from){
      curpass-=pq.poll().pass;
    }
    curpass+=trip.pass;
    if(curpass>capacity){
      return false;
    }
    //add current trip's passengers to heap
    pq.add(new Pair(trip.to,trip.pass));
   }
   return true;
    }
}