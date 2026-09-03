class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
      ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
      int[] ans=new int[numCourses];
      int ind=0;
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
      ans[ind++]=node;
      for(int it:adj.get(node)){
          indegree[it]--;
          if(indegree[it]==0){
            q.add(it);
          }
      }
     }
     if(ind==numCourses)
      return ans;
     return new int[0];
    }
}