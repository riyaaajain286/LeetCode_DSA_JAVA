class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int rows = boxGrid.length;
        int cols = boxGrid[0].length;

        // Step 1: Let stones fall to the right
        for (int i = 0; i < rows; i++) {
            int empty = cols - 1;

            for (int j = cols - 1; j >= 0; j--) {

                if (boxGrid[i][j] == '*') {
                    empty = j - 1;
                }

                else if (boxGrid[i][j] == '#') {
                    boxGrid[i][j] = '.';
                    boxGrid[i][empty] = '#';
                    empty--;
                }
            }
        }

        // Step 2: Rotate 90 degree clockwise
        char[][] res = new char[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                res[j][rows - 1 - i] = boxGrid[i][j];
            }
        }

        return res;
    }
}