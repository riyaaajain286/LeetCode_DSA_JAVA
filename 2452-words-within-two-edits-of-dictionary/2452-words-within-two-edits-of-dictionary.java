class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans=new ArrayList<>();
        for(String q:queries){
            if(match(q,dictionary)){
                ans.add(q);
            }
        }
        return ans;
    }
    private boolean match(String q,String[] dictionary){
        
        for(String d:dictionary){
            int replace=0;
            for(int i=0;i<d.length();i++){
                if(q.charAt(i)!=d.charAt(i)){
                    replace++;
                }
                 if(replace>2){
                    break;
                }
            }
            if(replace<=2){
                    return true;
                }
        }
        return false;
    }
}