package matrix;

/**
 * This class
 * 因为是有序的所以直接可以看成一维数组，进行二分法
 * time: O(log(m*n))
 * space: O(1)
 * @author Yi Qin
 * @date 2018-05-07
 */
public class Searcha2DMatrix74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        //注意这块没有减一
        int row = matrix.length;
        int col = matrix[0].length;
        int begin = 0, end = row * col - 1;
        //这里判断条件是小于等于
        while(begin <= end){
            int mid = (end - begin)/2 + begin;
            //等到相对应的横纵坐标！！！
            int count = matrix[mid/col][mid%col];
            if(count == target){
                return true;
            }else if(count < target){
                begin = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return false;
    }
}
