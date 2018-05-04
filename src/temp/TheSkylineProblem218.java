package temp;

import java.util.*;

/**
 * This class
 * 扫描线法
 * @author Yi Qin
 * @date 2018-05-04
 */
public class TheSkylineProblem218 {
    public static void main(String[] args) {
        int[] arr1 = {2, 9, 10};
        int[] arr2 = {3, 7, 15};
        int[] arr3 = {5, 12, 12};
        int[] arr4 = {15, 20, 10};
        int[] arr5 = {19, 24, 8};
        int[][] input = {arr1, arr2, arr3, arr4, arr5};
        getSkyline(input);
    }

    public static List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        //降维 三维坐标降到二维 为了区分开始坐标和结束坐标开始坐标用负数来标志
        for (int[] b: buildings){
            heights.add(new int[]{b[0], -b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        //如果x 不等按x轴升序排列， 如果x轴相等按y坐标升序排列 --- 保证开始坐标排在最前头
        Collections.sort(heights, (a, b) -> (a[0] == b[0])? a[1] - b[1] : a[0] - b[0]);
        //按值的大小降序排列 大的在前头
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b-a));
        pq.offer(0);
        int prev = 0;
        for(int[] h: heights){
            if(h[1] < 0){
                pq.offer(-h[1]);
            }else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if(prev != cur){
                res.add(new int[]{h[0], cur});
                prev = cur;
            }
        }
        return res;
    }
}
