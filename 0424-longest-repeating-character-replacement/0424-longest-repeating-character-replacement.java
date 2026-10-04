class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq=new int[26];
        int left=0,maxfreq=0,maxlen=0;
       for(int right=0;right<s.length();right++){
          freq[s.charAt(right)-'A']++;
          maxfreq=Math.max(maxfreq,freq[s.charAt(right)-'A']);
          while((right-left+1)-maxfreq>k){
            freq[s.charAt(left)-'A']--;
            maxfreq=0;
            left++;
            for(int i=0;i<26;i++){
                maxfreq=Math.max(maxfreq,freq[i]);
            }
          }
          if((right-left+1)-maxfreq<=k)
              maxlen=Math.max(maxlen,(right-left+1));
       }
       return maxlen;
    }
}