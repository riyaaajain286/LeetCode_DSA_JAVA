class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer>  ans=new ArrayList<>();
        int[] freq=new int[26];
        int n=s.length();
        int m=p.length();
        if(n<m) return ans;
        for(char ch:p.toCharArray()){
            freq[ch-'a']++;
        }
        int c=m,left=0;
        int right=0;
        // for(int right=0;right<n;right++){
        while(right<n){
            char r=s.charAt(right);
            if(freq[r-'a']>0)
              c--;
            freq[r-'a']--;
            right++;
            
            if(c==0){
                ans.add(left);
            }
            if(right-left==m){
                char l=s.charAt(left);
                if(freq[l-'a']>=0)
                    c++;
                freq[l-'a']++;
                left++;
            }
              
        }
        return ans;
    }
}