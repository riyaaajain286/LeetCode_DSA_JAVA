class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones){
            pq.add(i);
        }
           int last=0;
        while(pq.size()>1){
           int first=pq.poll();
           int second=pq.poll();
           if(first!=second){
           last=first-second;
           pq.add(last);
           }
        }
        return pq.isEmpty()?0:pq.peek();
    }
}