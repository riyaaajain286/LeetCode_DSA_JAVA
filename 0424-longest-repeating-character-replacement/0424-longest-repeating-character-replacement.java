class Solution {
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int l=0,maxlen=0,maxfreq=0;
        int[] freq=new int[26];
        for(int r=0;r<n;r++){
           freq[s.charAt(r)-'A']++;
           maxfreq=Math.max(maxfreq,freq[s.charAt(r)-'A']);
           while((r-l+1)-maxfreq>k){
            freq[s.charAt(l)-'A']--;
            // maxfreq=0;
            l++;
           }
        //    for(int i=0;i<26;i++){
        //     maxfreq=Math.max(maxfreq,freq[i]);
        //    }
           if((r-l+1)-maxfreq<=k){
            maxlen=Math.max(maxlen,(r-l+1));
            
           }
        }
        return maxlen;
    }
}