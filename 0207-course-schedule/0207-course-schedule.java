class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] it:prerequisites){
           adj.get(it[1]).add(it[0]);
           indegree[it[0]]++;
        }
     
     Queue<Integer> q=new LinkedList<>();
     
     for(int i=0;i<numCourses;i++){
      if(indegree[i]==0){
         q.add(i);
        
      }
     }
    int c=0;
     while(!q.isEmpty()){
      int node=q.poll();
      c++;
      for(int it:adj.get(node)){
          indegree[it]--;
          if(indegree[it]==0){
            q.add(it);
            
          }
      }
     }
    if(c==numCourses) return true;
    return false;
     
  }
}