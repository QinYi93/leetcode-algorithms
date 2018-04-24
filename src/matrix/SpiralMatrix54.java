package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * This class
 * time: O(m*n)
 * space: O(m*n)
 * @author Yi Qin
 * @date 2018-04-23
 */
public class SpiralMatrix54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0] == null || matrix[0].length == 0)
            return res;
        int colS = 0;
        int colE = matrix[0].length - 1;
        int rowS = 0;
        int rowE = matrix.length - 1;
        while(colS <= colE && rowS <= rowE){
            for(int i = colS; i<=colE; i++){
                res.add(matrix[rowS][i]);
            }
            rowS++;

            for(int i = rowS; i<= rowE; i++){
                res.add(matrix[i][colE]);
            }
            colE--;
            //这个判断非常重要，因为是对最后一行进行操作，所以要看最后一行是否符合范围
            if(rowS <= rowE){
                for(int i = colE; i >= colS; i--){
                    res.add(matrix[rowE][i]);
                }
                rowE--;
            }
            //同上
            if(colS <= colE){
                for(int i = rowE; i>= rowS; i--){
                    res.add(matrix[i][colS]);
                }
                colS++;
            }
        }
        return res;
    }
}
