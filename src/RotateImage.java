public class RotateImage {

    void rotate(int[][] matrix){
        if(matrix.length ==1) return;



    }

}

class Main{
    public static void main(String[] args) {
       RotateImage rotateImage = new RotateImage() ;


    }
}


/**
 * 3번이면
 * 2번 돌리고
 * 가운데 냅두고 -> 2번
 *
 * 4 * 4
 * 3번 돌리고
 * 1번 돌리고 -> 4번
 *
 * 5 * 5
 * 4번 돌리고
 * 3번 돌리는 것 덧셈 -> 2번 -> 6번
 * 3*3
 * 0,0 / 0,2 / 2,2 / 2,0
 * 0,1 / 1,2 / 2,1 / 1,0
 *
 * 0,0 / 0,3 / 3,3 / 3,0
 * 0,1 / 1,3 / 3,2 / 2,0
 * 0,2 / 2,3 / 3,1 / 1,0
 */