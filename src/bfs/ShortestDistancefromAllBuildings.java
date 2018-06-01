package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-05-31
 */
public class ShortestDistancefromAllBuildings {
    public static void main(String[] args) {
        shortestDistance(new int[][]{{1,0,2,0,1},{0,0,0,0,0},{0,0,1,0,0}});
    }

    public static int shortestDistance(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        int[][] number = new int[m][n];
        int building = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    building++;
                    dfs(grid, i, j, dist, number);
                }
            }
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0 && dist[i][j] != 0 && number[i][j] == building){
                    res = Math.min(res, dist[i][j]);
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void dfs(int[][] grid, int row, int col, int[][] dist, int[][] number){
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int distance = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{row, col});
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while(!queue.isEmpty()){
            distance++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cur = queue.poll();
                for(int k = 0; k < dirs.length; k++){
                    int x = cur[0] + dirs[k][0];
                    int y = cur[1] + dirs[k][1];
                    if(x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == 0){
                        dist[x][y] += distance;
                        visited[x][y] = true;
                        number[x][y]++;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }
    }
}
