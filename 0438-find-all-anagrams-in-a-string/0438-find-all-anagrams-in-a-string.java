class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        int n=s.length();
        int m=p.length();
        if(n<m) return ans;
        int left=0,right=0;
        int[] freq=new int[26];
        for(char ch:p.toCharArray()){
            freq[ch-'a']++;
        }
        int count=m;
        while(right<n){
            char ch=s.charAt(right);
            if(freq[ch-'a']>0)
               count--;
            freq[ch-'a']--;
            right++;
            
            if(count==0) ans.add(left);
            if(right-left==m){
               char remove=s.charAt(left);
               if(freq[remove-'a']>=0)
                  count++;
                freq[remove-'a']++;
                left++;
            }
        }
        return ans;
        
    }
}