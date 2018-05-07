package matrix;

/**
 * This class
 * time :O(m+n)
 * space: O(1)
 * 注意这道题不能用二分法，因为不能保证每一行的最后一个数字都比下一行的第一个数字大
 * @author Yi Qin
 * @date 2018-05-07
 */
public class Searcha2DMatrixII240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while(row <= matrix.length - 1 && col >= 0){
            if(target == matrix[row][col]){
                return true;
            }else if(target < matrix[row][col]){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}
