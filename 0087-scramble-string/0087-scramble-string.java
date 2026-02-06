class Solution {
    Map<String,Boolean> memo=new HashMap<>();
    public boolean isScramble(String s1, String s2) {
       boolean ans=solve(s1,s2);
        return ans;
    }
    public  boolean solve(String s1,String s2){
       int n=s1.length();
       //mcm format
       //i=1,j=n-1;
       //base condition
       if(s1.equals(s2))
        return true;
        if(s1.length()!=s2.length())
         return false;
       if(n==1)
        return s1.equals(s2);
        String key=s1+"_"+s2;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        //k loop
        for(int i=1;i<=n-1;i++){
            //swap case
          if(solve(s1.substring(0,i),s2.substring(n-i)) &&
           solve(s1.substring(i),s2.substring(0,n-i))){
            memo.put(key,true);
            return true;
          }
          //no swap case
            if(solve(s1.substring(0,i),s2.substring(0,i)) && 
            solve(s1.substring(i,n),s2.substring(i,n))){
            memo.put(key,true);
            return true;
            }
        }
            memo.put(key,false);
            return false;
        }
}