class Disjoint{
 int[] parent;
 int[] rank;
  public Disjoint(int n){
    parent=new int[n];
    rank=new int[n];
    for(int i=0;i<n;i++){ 
      parent[i]=i;
      rank[i]=0;
    }
  }
    //parent and compress path also
    public  int findparent(int node){
      if(parent[node]==node)  return node;

      //path compression step
      parent[node]=findparent(parent[node]);
      return parent[node];

    }
    //union by rank
    public   void unionByRank(int u,int v){
    int pu=findparent(u);
    int pv=findparent(v);
    if(pu==pv) return;//already same set
// Attach smaller rank tree under larger rank tree
    if(rank[pu]<rank[pv]){
      parent[pu]=pv;
    }
    else if(rank[pv]<rank[pu]){
      parent[pv]=pu;
    }
    else{
      parent[pv]=pu;
      rank[pu]++;// Increase rank if both equal 
    }
    }
}
class Solution {
    public int findCircleNum(int[][] isConnected) {
        if(isConnected==null||isConnected.length==0)  return 0;
        int V=isConnected.length;
        Disjoint ds=new Disjoint(V);
        for(int i=0;i<V;i++){
            for(int j=i+1;j<V;j++){
                if(isConnected[i][j]==1){
                    ds.unionByRank(i,j);
                }
            }
        }
        int c=0;
        for(int i=0;i<V;i++){
            if(ds.findparent(i)==i){
                c++;
            }
        }
        return c;
    }
}