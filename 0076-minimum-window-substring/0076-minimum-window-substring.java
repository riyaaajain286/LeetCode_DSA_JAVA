class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(n<m) return "";
        int l=0,minlen=Integer.MAX_VALUE,start=0,c=m;
        int[] freq=new int[128];
        for(char ch:t.toCharArray()){
            freq[ch]++;
        }
        for(int r=0;r<n;r++){
            int a=s.charAt(r);
            if(freq[a]>0){
                c--;
            }
            freq[a]--;
            while(c==0){
              if(minlen>r-l+1){
                minlen=r-l+1;
                start=l;
              }
              char left=s.charAt(l);
              freq[left]++;
              if(freq[left]>0)
                   c++;
              l++; 
                
            }
        }
            if(minlen==Integer.MAX_VALUE){
                return "";
            }
            
             return s.substring(start,start+minlen);
    }
}