class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Long> pq=new PriorityQueue<>(Collections.reverseOrder());
        long allsum=0;
        for(long i:target){
            pq.add(i);
            allsum+=i;
        }
      
        long remsum=0;
        long element=0;
      
        //maxelement=remsum+element
        while(true){
              long maxelement=pq.poll();
           remsum=allsum-maxelement;
           //edge cases
           if(maxelement==1||remsum==1){
            return true;
           }
           if(remsum==0||maxelement<remsum||maxelement%remsum==0){
            return false;
           }
          
           element=(int)(maxelement%remsum);
           pq.add(element);
           allsum=remsum+element;
         
        }
  
    }
}