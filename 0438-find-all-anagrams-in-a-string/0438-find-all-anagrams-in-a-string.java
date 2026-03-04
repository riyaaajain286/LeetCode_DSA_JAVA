class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        int n=p.length();
        int m=s.length();
        if(n>m) return ans;
        int[] freq=new int[26];
        // frequency of p
        for(char ch:p.toCharArray()){
            freq[ch-'a']++;
        }
        int left=0;
        int right=0;
        int c=n;
        while(right<m){
           // if character exists in freq
           if(freq[s.charAt(right)-'a']>0){
            c--;
           }
           freq[s.charAt(right)-'a']--;
           right++;
           if(c==0){
            ans.add(left);
           }
           if(right-left==n){
                if(freq[s.charAt(left)-'a']>=0){
                c++;
                }
           freq[s.charAt(left)-'a']++;
           left++;
           }
        }
     return ans;
    }
}