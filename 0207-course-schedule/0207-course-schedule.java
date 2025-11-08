class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int v=prerequisites.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
         adj.add(new ArrayList<>());
        }
        for(int i=0;i<v;i++){
            int course=prerequisites[i][0];
            int prereq=prerequisites[i][1];
            adj.get(prereq).add(course);
        }
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(int it:adj.get(i)){
                indegree[it]++;
            }
        }
      
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
          int c=0;
         while(!q.isEmpty()){
            int node=q.remove();
            c++;
            for(int it:adj.get(node)){
                indegree[it]--;
                   if(indegree[it]==0) q.add(it);
            }
          }
        if(c==numCourses) return true;
        return false;
    }
}