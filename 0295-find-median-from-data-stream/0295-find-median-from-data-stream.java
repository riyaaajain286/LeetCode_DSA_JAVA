class MedianFinder {
       PriorityQueue<Integer> leftmaxheap;
  PriorityQueue<Integer> rightminheap;
    public MedianFinder() {
  leftmaxheap= new PriorityQueue<>(Collections.reverseOrder());
  rightminheap=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
         if(leftmaxheap.isEmpty()){
      leftmaxheap.add(num);
      return;
    }
    if(num>leftmaxheap.peek()){
      rightminheap.add(num);
    }
    else{
      leftmaxheap.add(num); 
    }
    balanceheap();
    }
     void balanceheap(){
    if(rightminheap.size()>leftmaxheap.size()){
      leftmaxheap.add(rightminheap.peek());
      rightminheap.poll();
}
   else{
     if(rightminheap.size()<leftmaxheap.size()-1){
      rightminheap.add(leftmaxheap.peek());
      leftmaxheap.poll();
     }
   }
  }
    
    public double findMedian() {
         if(leftmaxheap.size()>rightminheap.size()){
       return leftmaxheap.peek();
    }
    else{
      double ans=leftmaxheap.peek()+rightminheap.peek();
      ans/=2;
      return ans;
    }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */