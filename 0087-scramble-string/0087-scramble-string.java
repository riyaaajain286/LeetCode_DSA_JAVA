class Solution {
    static HashMap<String,Boolean> map=new HashMap<>();
    public boolean isScramble(String s1, String s2) {
         return solve(s1,s2); 
   }
   private static boolean solve(String a,String b){
    if(a.equals(b)) return true;
    int n=a.length(),m=b.length();
    if(n!=m) return false;
    if(n==1){
      return a.equals(b);
    }
    String key=a+" "+b;
    if(map.containsKey(key)) return map.get(key);
    //pruning check
    boolean ans=checkFreq(a,b);
    if(ans==false){
      map.put(key,ans);
      return false;
    }
     
    boolean flag=false;
    for(int k=1;k<=n-1;k++){
      //swap case
      boolean condition1=solve(a.substring(0,k),b.substring(n-k,n))
                         &&
                         solve(a.substring(k,n),b.substring(0,n-k));
        
        // return true;
      

      //no swap case
      boolean condition2=solve(a.substring(0,k),b.substring(0,k))
                         &&
                         solve(a.substring(k,n),b.substring(k,n));
     
        // return true;
       
       if(condition1 || condition2){
        flag=true;
        // map.put(key,flag);
        break;
       }
    }
    map.put(key,flag);
     return flag;
   
   }
   private static boolean checkFreq(String a,String b){
      int[] freq=new int[26];
      for(int i=0;i<a.length();i++){
        freq[a.charAt(i)-'a']++;
        freq[b.charAt(i)-'a']--;
      }
      for(int i:freq){
        if(i!=0)
         return false;
      }
      return true;
   }
}