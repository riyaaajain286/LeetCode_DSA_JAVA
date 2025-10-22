class Solution { 
    public boolean isPossible(int[] target) {
     PriorityQueue<Long> pq=new PriorityQueue<>(Collections.reverseOrder()); 
     long allsum=0;
      for(long i:target){ 
        pq.add(i); 
        allsum+=i;
         } 
       
         long remsum=0;
          long element=0; //maxelement=remsum+element 
          while(pq.peek()!=1){
              long maxelement=pq.poll(); 
             remsum=allsum-maxelement;
              //edge cases
               if(remsum<=0||remsum>=maxelement){
                return false;
                }
                element=maxelement%remsum; 
                if(element==0){ 
                    if(remsum!=1) {
                         return false;
                    } 
                          else{
                             return true;
                        }
                }
                 allsum=remsum+element;
                  pq.add(element);
            }
            return true;
        }
    }