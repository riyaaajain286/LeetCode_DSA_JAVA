class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
  
        int drinkb=numBottles;
              int emptyb= numBottles;    ;
       
        while(emptyb>=numExchange){
            emptyb-=numExchange;
            drinkb++;
            numExchange++;
            emptyb++;

        }
        return drinkb;
    }
}