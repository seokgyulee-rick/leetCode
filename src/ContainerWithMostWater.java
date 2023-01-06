public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1,1};
        System.out.println(maxArea(height));
    }
    static int maxArea(int[] height) {
        int maxHeight = 0;
        for (int j : height) {
            if (j > maxHeight) maxHeight = j;
        }
        int maxWaterVolume = 0;


        for (int i = 1 ; i <= maxHeight ; i++ ){
            int left = 0;
            int right = height.length-1;

            for (int j = 0 ; j < height.length ; j++) if(height[j] >= i) {
                left = j;
                break;
            }
            for (int k = height.length -1 ; k >=0  ; k--) if(height[k] >= i) {
                right = k;
                break;
            }
            int currentWaterVolueme = (right - left)* i;
//            System.out.println("i "+i+" currentWaterVolueme "+ currentWaterVolueme + " left: "+ left+" right : "+ right);

            if(maxWaterVolume < currentWaterVolueme ) {
                maxWaterVolume = currentWaterVolueme;
//                System.out.println(right+" "+left+" "+ maxWaterVolume);
            }


        }

        return maxWaterVolume;
    }
}
/**
 * 방법 1.
 * 아래에서부터 올라오면서
 * 두 포인트를 알아내서 그 물의 양을 계산하고 max 값 계산
 * 포인트가 하나가 되면 계산 종료.
 */

/**
 * 솔루션
 * 브루트 포스 or 투포인터
 *
 *
 * public class Solution {
 *     public int maxArea(int[] height) {
 *         int maxarea = 0;
 *         int left = 0;
 *         int right = height.length - 1;
 *         while (left < right) {
 *             int width = right - left;
 *             maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
 *             if (height[left] <= height[right]) {
 *                 left++;
 *             } else {
 *                 right--;
 *             }
 *         }
 *         return maxarea;
 *     }
 * }
 *
 *
 * public class Solution {
 *     public int maxArea(int[] height) {
 *         int maxarea = 0;
 *         for (int left = 0; left < height.length; left++) {
 *             for (int right = left + 1; right < height.length; right++) {
 *                 int width = right - left;
 *                 maxarea = Math.max(maxarea, Math.min(height[left], height[right]) * width);
 *             }
 *         }
 *         return maxarea;
 *     }
 * }
 */