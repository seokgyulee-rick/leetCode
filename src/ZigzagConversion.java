public class ZigzagConversion {

    public static void main(String[] args) {
        int numRows =4;
        String s = "PAYPALISHIRING";
        System.out.println(convert(s, numRows));
    }
    static String convert(String s, int numRows) {
        if(numRows == 1) return s;
        String answer = "";
        char [][] Array = new char[numRows][s.length()];
        String direction = "downward";
        int previousPositionX = 0;
        int previousPositionY = 1;
        int diff = Array[0][0];
        Array[0][0] = s.charAt(0);
        for(int i = 1 ; i < s.length(); i++){
            if(direction.equals("downward")){
//                System.out.println("downward "+ previousPositionY +" "+ previousPositionX+" : "+ s.charAt(i));
                Array[previousPositionY][previousPositionX] = s.charAt(i);
                if(previousPositionY == numRows - 1 ){
                    direction = "upward";
                    previousPositionY -= 1;
                    previousPositionX += 1;
                }else{
                    previousPositionY += 1;
                }
            } else{
//                System.out.println("upward "+previousPositionY +" "+ previousPositionX+" : "+ s.charAt(i));
                Array[previousPositionY][previousPositionX] = s.charAt(i);
                if(previousPositionY == 0 ){
                    direction = "downward";
                    previousPositionY += 1;
                }else{
                    previousPositionY -= 1;
                    previousPositionX += 1;
                }
            }
        }
        for (int j = 0 ; j < numRows; j++){
            for (int k = 0 ; k <= previousPositionX ; k++){
                    if(diff != Array[j][k]) answer += Array[j][k];
                }
        }
    return answer;
    }
}

/**
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 첫 줄 = 4칸 차이
 * 두째 줄 = 2칸 차이
 * 셋째 줄 = 4칸 차이
 *
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 *
 * 첫 줄 =   6칸 차이
 * 두째 줄 = 4칸, 2칸, 4칸 차이
 * 셋째 줄 = 2칸, 4칸, 2칸 차이
 * 넷째 줄 = 6칸 차이
 *
 * numrows = 5
 * 8, 6, 4, 2, 8
 *
 * PAYPALISHIRING
 *
 * PYAIHRNAPLSIIYAIHRN
 * PAHNAPLSIIGYIR
 *
 * Output
 * "PINALIGYAIHRNPI"
 * Expected
 * "PINALSIGYAHRPI"
 */


/**
 * 솔루션
 * class Solution {
 *     public String convert(String s, int numRows) {
 *         if (numRows == 1) {
 *             return s;
 *         }
 *
 *         int n = s.length();
 *         int sections = (int) Math.ceil(n / (2 * numRows - 2.0));
 *         int numCols = sections * (numRows - 1);
 *
 *         char[][] matrix = new char[numRows][numCols];
 *         for (char[] row: matrix) {
 *             Arrays.fill(row, ' ');
 *         }
 *
 *         int currRow = 0, currCol = 0;
 *         int currStringIndex = 0;
 *
 *         // Iterate in zig-zag pattern on matrix and fill it with string characters.
 *         while (currStringIndex < n) {
 *             // Move down.
 *             while (currRow < numRows && currStringIndex < n) {
 *                 matrix[currRow][currCol] = s.charAt(currStringIndex);
 *                 currRow++;
 *                 currStringIndex++;
 *             }
 *
 *             currRow -= 2;
 *             currCol++;
 *
 *             // Move up (with moving right also).
 *             while (currRow > 0 && currCol < numCols && currStringIndex < n) {
 *                 matrix[currRow][currCol] = s.charAt(currStringIndex);
 *                 currRow--;
 *                 currCol++;
 *                 currStringIndex++;
 *             }
 *         }
 *
 *         StringBuilder answer = new StringBuilder();
 *         for (char[] row: matrix) {
 *             for (char character: row) {
 *                 if (character != ' ') {
 *                     answer.append(character);
 *                 }
 *             }
 *         }
 *
 *         return answer.toString();
 *     }
 * }
 *
 * // 솔루션 2 섹션으로 구분지어서 해결
 * 섹션만큼 더해 주고, 사잇값 더해주고
 * 그런데 while문으로 중간에 구분
 * class Solution {
 *     public String convert(String s, int numRows) {
 *         if (numRows == 1) {
 *             return s;
 *         }
 *
 *         StringBuilder answer = new StringBuilder();
 *         int n = s.length();
 *         int charsInSection = 2 * (numRows - 1);
 *
 *         for (int currRow = 0; currRow < numRows; ++currRow) {
 *             int index = currRow;
 *
 *             while (index < n) {
 *                 answer.append(s.charAt(index));
 *
 *                 // If currRow is not the first or last row
 *                 // then we have to add one more character of current section.
 *                 if (currRow != 0 && currRow != numRows - 1) {
 *                     int charsInBetween = charsInSection - 2 * currRow;
 *                     int secondIndex = index + charsInBetween;
 *
 *                     if (secondIndex < n) {
 *                         answer.append(s.charAt(secondIndex));
 *                     }
 *                 }
 *                 // Jump to same row's first character of next section.
 *                 index += charsInSection;
 *             }
 *         }
 *
 *         return answer.toString();
 *     }
 * }
 */