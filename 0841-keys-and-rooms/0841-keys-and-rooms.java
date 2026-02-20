class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n=rooms.size();
        boolean[] vis=new boolean[n];
        dfs(rooms,vis,0);
        for(boolean room:vis){
            if(room == false) return false;
        }
        return true;
    }
       
    public void dfs(List<List<Integer>> rooms,boolean[] vis,int node){
        vis[node]=true;
        // Traverse all keys in current room
       for(int el:rooms.get(node)){
                if(!vis[el])
                  dfs(rooms,vis,el);
            }
        }
        
    }
