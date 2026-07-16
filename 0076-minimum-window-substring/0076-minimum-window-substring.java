class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n<m) return "";
        int start=0,minWindow=Integer.MAX_VALUE;
        int l=0,r=0;
        int[] freq=new int[128];
        for(char ch:t.toCharArray()){
            freq[ch]++;
        }
        int countRequired=m;
        while(r<n){
            char right=s.charAt(r);
            if(freq[right]>0){
                countRequired--;
            }
            freq[right]--;
            while(countRequired==0){//a valid window found including all t chars
               if(r-l+1<minWindow){
                minWindow=r-l+1;
                start=l;
               }
               char left=s.charAt(l);
               freq[left]++;
               if(freq[left]>0){
                countRequired++;
               }
               l++;
              
              
            }
             r++;
        }
             return minWindow==Integer.MAX_VALUE?"":s.substring(start,start+minWindow);
        
     }
}