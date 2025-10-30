class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ans=new ArrayList<>();
        long result=1;
        ans.add(1);
        for(int col=1;col<=rowIndex;col++){
            result=result*((rowIndex+1)-col);
            result=result/(col);
            ans.add((int)result);
        }
        return ans;
    }
}