package array;

/**
 * This class 不需要记忆 理解位运算操作在里面的用处即可
 * time : O(m*n)
 * space: O(1)
 * @author Yi Qin
 * @date 2018-05-08
 */
public class GameofLife289 {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0) return;
        int m = board.length - 1;
        int n = board[0].length - 1;
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                int count = countNeighbor(board, i, j);
                if(board[i][j] == 1){
                    //只判断live 的时候count == 2 & 3的时候下一轮还会继续存活的 所以进行进位为1 即 1 -》 11
                    if(count == 2 || count == 3){
                        board[i][j] += 2;
                    }
                }else if(count == 3){
                    //died 的时候count == 3会死而复生 2 = 10类似于在上一位加一的操作
                    board[i][j] += 2;
                }
            }
        }
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                //整体右移一位
                board[i][j] = board[i][j] >> 1;
            }
        }
    }
    public int countNeighbor(int[][] board, int m, int n){
        int count = 0;
        //为了保证不超过边界值
        for(int i = Math.max(0, m-1); i <= Math.min(m+1, board.length - 1); i++){
            for(int j = Math.max(0, n-1); j <= Math.min(n+1, board[0].length - 1); j++){
                if(i == m && j == n) continue;
                //判断当前位是1还是0
                if((board[i][j] & 1) == 1) count++;
            }
        }
        return count++;
    }
}
