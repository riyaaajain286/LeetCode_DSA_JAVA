class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list=new ArrayList<>();
        // Step 1: Flatten grid
        for(int[] r:grid){
            for(int n:r){
                list.add(n);
            }
        }
        // Step 2: Check remainder condition
        int r=list.get(0)%x;
        for(int num:list){
            if(num%x!=r)
             return -1;
        }
        // Step 3: Sort
        Collections.sort(list);
         // Step 4: Find median
        int median=list.get(list.size()/2);
        // Step 5: Calculate operations
        int operations=0;
        for(int a:list){
            operations+=(Math.abs(a-median))/x;
        }
        return operations;
    }
}