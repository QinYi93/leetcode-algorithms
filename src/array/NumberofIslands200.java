package array;

/**
 * This class
 * DFS
 * time O(n*m)
 * space O(n)
 * @author Yi Qin
 * @date 2018-05-02
 */
public class NumberofIslands200 {
    private int m;
    private int n;
    public int numIslands(char[][] grid) {
        int res = 0;
        m = grid.length;
        if(m == 0) return 0;
        n = grid[0].length;
        for(int i = 0; i <  m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(char[][] grid, int i, int j){
        if(i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != '1') return;
        grid[i][j] = '0';
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
    }
}
