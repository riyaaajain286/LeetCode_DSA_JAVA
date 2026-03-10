class Solution {
    public String minWindow(String s, String t) {
        int[] freq=new int[128];
        int l=0,r=0;
        int c=t.length();
        int min=Integer.MAX_VALUE;
        int start=0;
        for(char tt:t.toCharArray()){
            freq[tt]++;
        }
        while(r<s.length()){
            char ch=s.charAt(r);
            if(freq[ch]>0){
                c--;
            }
             freq[ch]--;
             r++;
          while(c==0){//substring found now reduce it
            //    min=Math.min(min,r-l);
            if(r-l<min){
                min=r-l;
                start=l;
            }
            char lc=s.charAt(l);
               freq[lc]++;
               if(freq[lc]>0)//if lc positive means char occurs so minimize
                  c++;
               l++;
             }
            
        }
        // String ans=s.substring(start,start+min);
        return min == Integer.MAX_VALUE ? "" : s.substring(start, start + min);
    }
}