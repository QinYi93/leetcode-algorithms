package stackPriorityQueue;

import java.util.*;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-02-25
 */
public class TopKFrequentElements347 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println(topKFrequent(nums, 2));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(entry);
        }
        List<Integer> list = new LinkedList<>();
        while (list.size() < k) {
            list.add(queue.poll().getKey());
        }
        return list;
    }

}

