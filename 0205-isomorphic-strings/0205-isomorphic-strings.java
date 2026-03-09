class Solution {
    public boolean isIsomorphic(String s, String t) {
        int a=s.length();
        int b=t.length();
        if(a!=b) return false;
        Map<Character,Character> map1=new HashMap<>();
        Map<Character,Character> map2=new HashMap<>();
        for(int i=0;i<a;i++){
            char c=s.charAt(i);
            char d=t.charAt(i);
            if(map1.containsKey(c) && map1.get(c)!=d) return false;
            if(map2.containsKey(d) && map2.get(d)!=c) return false;
            map1.put(c,d);
            map2.put(d,c);
        }
        return true;
    }
}