class Solution {
    Map<String,Boolean> memo=new HashMap<>(); 
    public boolean isScramble(String s1, String s2) {
        return solve(s1,s2);
    }
    public boolean solve(String a,String b){
        int n=a.length();
        //base condn
        if(a.equals(b)) return true;
        if(a.length()!=b.length()) return false;
        if(n==1) 
         return a.equals(b);
         String key=a+" "+b;
         if(memo.containsKey(key))
           return memo.get(key);
        //k loop
        for(int i=1;i<=n-1;i++){
            //swap case
            if(solve(a.substring(0,i),b.substring(n-i)) && solve(a.substring(i,n),b.substring(0,n-i))){
                memo.put(key,true);
                return true;
            }
            //no swap case
            if(solve(a.substring(0,i),b.substring(0,i)) && solve(a.substring(i,n),b.substring(i,n))){
                memo.put(key,true);
                return true;
            }
        }
        memo.put(key,false);
        return false;
    }
}