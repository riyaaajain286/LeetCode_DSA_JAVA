class Solution {
    //kahn's algo
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree=new int[numCourses];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] i:prerequisites){
           adj.get(i[1]).add(i[0]);
           indegree[i[0]]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int j=0;j<numCourses;j++){
            if(indegree[j]==0){
                q.add(j);
            }
        }
        int ind=0;
        int[] ans=new int[numCourses];
        while(!q.isEmpty()){
            int node=q.poll();
            ans[ind++]=node;
             for(int adjnode:adj.get(node)){
                indegree[adjnode]--;
               if(indegree[adjnode]==0){
                q.add(adjnode);
               }
            }
        }
        if(ind==numCourses) 
         return ans;
       return new int[0];
        
       
    }
}