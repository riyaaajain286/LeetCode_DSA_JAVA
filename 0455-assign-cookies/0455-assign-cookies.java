class Solution {
    //greedy algorithm
    public int findContentChildren(int[] g, int[] s) {
        int n=g.length,m=s.length;
        int l=0;
        int r=0;
        Arrays.sort(g);
        Arrays.sort(s);
        //l will be at s and g will be at g
        while(l<m && r<n){
            if(g[r]<=s[l])
             r++;
            l++;
        }
        return r;
    }
}