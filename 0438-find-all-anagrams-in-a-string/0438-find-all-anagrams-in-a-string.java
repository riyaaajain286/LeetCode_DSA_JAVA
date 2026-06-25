class Solution {
    //sliding window + two pointer
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        int l=0,r=0;
        if(p.length()>s.length()) return ans;
        int[] freq=new int[26];
        int c=p.length();
        for(char ch:p.toCharArray()){
           freq[ch-'a']++;
        }
        while(r<s.length()){
            if(freq[s.charAt(r)-'a']>0){
                c--;
            }
            freq[s.charAt(r)-'a']--;
            r++;
            if(c==0){//whole p is matched with s
              ans.add(l);
            }
            if(r-l==p.length()){//check  substring or window =p then again increase freq for next check
                if(freq[s.charAt(l)-'a']>=0)
                  c++;
            freq[s.charAt(l)-'a']++;
            l++;
            }
        }
        return ans;
    }
}