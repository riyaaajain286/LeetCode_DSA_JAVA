class Solution {
    //recursive
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans=new ArrayList<>();
        Set<String> set=new HashSet<>(wordDict);
        solve(s,set,ans,0,"");
        return ans;
    }
    private void solve(String s, Set<String> set, List<String> ans,int i,String sentence){
        int n=s.length();
        
        if(i==n){
            ans.add(sentence.trim());
            return;
        }
        for(int j=i;j<n;j++){
           String word=s.substring(i,j+1);
            if(set.contains(word)){
            //    sentence+=word;
            //    sentence+=" ";
              solve(s,set,ans,j+1,sentence+word+" ");
            }
            
        }
         
    }
}