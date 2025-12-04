class Disjoint{
    int[] parent;
    int[] size;
    public Disjoint(int n){
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            size[i]=1;
            parent[i]=i;
        }
    }
    //find parent and compress path also
    public int findparent(int node){
        if(parent[node]==node) return node;
        parent[node]=findparent(parent[node]);
        return parent[node];
    }
    public void unionBysize(int u,int v){
        int pu=findparent(u);
        int pv=findparent(v);
        if(pu==pv) return;//same component
        if(size[pu]<size[pv]){
            parent[pu]=pv;
            size[pv]+=size[pu];
        }
        else{
            parent[pv]=pu;
            size[pu]+=size[pv];
        }
    }
}
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        Disjoint ds=new Disjoint(n*m);
        //union all 1s
        int[] dr={-1,0,1,0};
        int[] dc={0,1,0,-1};
        for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(grid[r][c]==1){
                    int node=r*m+c;
                  //check neighbours for creating a component
                  for(int k=0;k<4;k++){
                    int nr=r+dr[k];
                    int nc=c+dc[k];
                    if(nr>=0&&nc>=0&&nr<n&&nc<m&&grid[nr][nc]==1){
                        int adjnode=nr*m+nc;
                        ds.unionBysize(node,adjnode);
                    }
                  }
                }
            }
        }
         //check largest size
          int maxsize=0;
          for(int r=0;r<n;r++){
            for(int c=0;c<m;c++){
                if(grid[r][c]==1){
                    int nodeno=r*m+c;
                    int pnode=ds.findparent(nodeno);
                    int psize=ds.size[pnode];
                  maxsize=Math.max(maxsize,psize);
                }
            }
          }
            return maxsize;
    }
}