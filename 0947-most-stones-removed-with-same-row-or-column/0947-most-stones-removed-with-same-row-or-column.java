class Solution {
  class Disjoint{
  static int[] parent;
  static int[] rank;
  public Disjoint(int n){
    parent=new int[n+1];
    rank=new int[n+1];
    for(int i=0;i<n;i++){ 
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
    public static boolean unionByRank(int u,int v){
    int pu=findparent(u);
    int pv=findparent(v);
    if(pu==pv) return false;//already same set
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
    return true;
    }
  }
    public int removeStones(int[][] stones) {
       int n=stones.length;
       Disjoint ds=new Disjoint(n);
       int removed=0;
       // Union all stone pairs that share row or column
       for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            if(stones[i][0]==stones[j][0]||stones[i][1]==stones[j][1]){
               if(ds.unionByRank(i,j)){
                removed++;
               }
            }
        }
       } 
       return removed;
    }
}