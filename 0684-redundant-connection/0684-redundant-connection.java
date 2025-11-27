class Disjoint{
  static int[] parent;
  static int[] rank;
  public Disjoint(int n){
    parent=new int[n+1];
    rank=new int[n+1];
    for(int i=0;i<=n;i++){ 
      parent[i]=i;
      rank[i]=0;
    }
  }
    //parent and compress path also
    public static int findparent(int node){
      if(parent[node]==node)  return node;

      //path compression step
      parent[node]=findparent(parent[node]);
      return parent[node];

    }
    //union by rank
    public static  void unionByRank(int u,int v){
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
    public int[] findRedundantConnection(int[][] edges) {
        int m=edges.length;
        if(edges==null||edges.length==0)  return new int[]{-1,-1};
        Disjoint ds=new Disjoint(m);
        for(int i=0;i<m;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            if(ds.findparent(u)==ds.findparent(v)){
                return new int[]{u,v};
            }
            else{
                ds.unionByRank(u,v);
            }
        }
        return new int[]{-1,-1};
    }
}