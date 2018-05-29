package unionfind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-05-29
 */
public class NumberOfIslandsII305 {
    public static void main(String[] args) {
        int[][] positions = {{0,0}, {0,1}, {0,2}, {1,2}, {2,1}, {2,2}};
        numIslands2(3, 3, positions);
    }
    //找到二维变成一维后的邻居
    static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        if (m <= 0 || n <= 0) return res;

        int count = 0;
        //降维二维变一维
        int[] roots = new int[m * n];
        Arrays.fill(roots, -1);

        for (int[] pair : positions) {
            int position = n * pair[0] + pair[1];
            roots[position] = position;
            count++;
//遍历邻居节点
            for (int[] dir : dirs) {
                int x = pair[0] + dir[0];
                int y = pair[1] + dir[1];
                int curPos = n * x + y;
                //如果邻居节点并没有被遍历到说明是没有land的
                if (x < 0 || x >= m || y < 0 || y >= n || roots[curPos] == -1) {
                    continue;
                }
                //找到最初land对应的index是哪一个
                int anoIsland = find(roots, curPos);
                if (position != anoIsland) {
                    roots[position] = anoIsland;
                    position = anoIsland;
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }

    private static int find(int[] roots, int i) {
        while (i != roots[i]) {
            i = roots[i];
        }
        return i;
    }
}
