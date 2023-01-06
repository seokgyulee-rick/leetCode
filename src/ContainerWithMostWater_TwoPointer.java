public class ContainerWithMostWater_TwoPointer {
    public static void main(String[] args) {
        int[] height = {2,3,4,5,18,17,6};
        System.out.println(maxArea(height));
    }
    static int maxArea(int[] height) {
        int maxHeight = 0;
        int maxWaterVolume = 0;
        int left = 0 ;
        int right = height.length-1;

        while(left< right){
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);

            if(maxWaterVolume < width*currentHeight) {
                maxWaterVolume = width*currentHeight;
            }
            System.out.println(left+" "+right+" "+width*currentHeight);
            if(currentHeight == height[left]) left++;
            else right--;
        }
        return maxWaterVolume;
    }
}
