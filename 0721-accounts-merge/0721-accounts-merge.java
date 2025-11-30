class Disjoint{
   int[] parent;
   int[] rank;
  public Disjoint(int n){
    parent=new int[n+1];
    rank=new int[n+1];
    for(int i=0;i<n;i++){ 
      parent[i]=i;
      rank[i]=0;
    }
  }
    //parent and compress path also
    public int findparent(int node){
      if(parent[node]==node)  return node;

      //path compression step
      parent[node]=findparent(parent[node]);
      return parent[node];

    }
    //union by rank
    public void unionByRank(int u,int v){
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
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
       int n =accounts.size();
       Disjoint ds=new Disjoint(n);
       Map<String,Integer> names=new HashMap<>();
       //build DSU connections
       for(int i=0;i<n;i++){
        List<String> eachAcc=accounts.get(i);
        for(int j=1;j<eachAcc.size();j++){
           String emails=eachAcc.get(j);
           if(!names.containsKey(emails)){
            names.put(emails,i);
           }
           else{
            ds.unionByRank(i,names.get(emails));
           }
        }
       } 
    
    //group emails by parent
    Map<Integer,TreeSet<String>> sorted=new HashMap<>();
    for(String email:names.keySet()){
        int index=names.get(email);
        int parent=ds.findparent(index);
        if(!sorted.containsKey(parent)){
            sorted.put(parent,new TreeSet<>());
        }
        sorted.get(parent).add(email);
    }
    //prepare final answer
    List<List<String>> ans=new ArrayList<>();
    for(int parent:sorted.keySet()){
        List<String> temp=new ArrayList<>();
        temp.add(accounts.get(parent).get(0));//name
        temp.addAll(sorted.get(parent));//sorted emails
        ans.add(temp);
    }
    return ans;
}
}