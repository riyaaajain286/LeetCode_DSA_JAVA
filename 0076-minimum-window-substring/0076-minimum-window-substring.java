class Solution {
    public String minWindow(String s, String t) {
        int n=s.length();
        if(t.length()>n) return "";
        int countRequired=t.length();
        Map<Character,Integer> map=new HashMap<>();
        for(char ch:t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        int i=0,j=0;
        int minlen=Integer.MAX_VALUE;
        int start=0;
        while(j<n){
             // Expand window
            char right=s.charAt(j);
             if (map.containsKey(right)) {
              if( map.get(right)>0)
               countRequired--;
               
            
            // map.get (s.charAt(j))--;
            map.put(right,map.get(right)-1);  
            }  
            //shrink window
            while(countRequired==0){//a window found with all chars of t
              if(j-i+1<minlen){
                minlen=j-i+1;
                start=i;
              }
            //   char left=s.charAt(i);
            //   map.get(s.charAt(i))--;
              char left=s.charAt(i);
             if(map.containsKey((left))){
              map.put(left,map.get(left)+1);
               if(map.get(left)>0){
               countRequired++;
              }
             }
              i++;
            }

          j++;
        }
        return minlen==Integer.MAX_VALUE?"":s.substring(start,start+minlen);

    }
 }
