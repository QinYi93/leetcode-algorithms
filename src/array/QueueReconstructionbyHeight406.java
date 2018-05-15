package array;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-05-14
 */
public class QueueReconstructionbyHeight406 {
    public static void main(String[] args) {
        int[][] input = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        reconstructQueue(input);

    }
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (p1, p2) -> {
            return p1[0] == p2[0] ? p1[1] - p2[1] : p2[0] - p1[0];
        });
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < people.length; i++)
            list.add(people[i][1], people[i]);
        return list.toArray(people);
    }
}
