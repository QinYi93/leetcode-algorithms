package stackPriorityQueue;

import com.sun.tools.corba.se.idl.constExpr.ShiftRight;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-02-24
 */
public class KthLargestElementinanArray215 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 6, 4};
        System.out.println(priorityQueue(arr, 2));
    }

    public static int findKthLargest(int[] nums, int k) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i : nums) {
            list.add(i);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2)
                    return -1;
                else if (o1 < o2) {
                    return 1;
                } else return 0;
            }
        });
        return list.get(k - 1);
    }

    /*
    quickselect time: O(k)
    space: O(1)
     */
    public static int quickSort(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int l = 0;
        int r = nums.length - 1;
        while (true) {
            int pos = position(nums, l, r);
            if (pos + 1 == k)
                return nums[pos];
            else if (pos + 1 > k)
                r = pos - 1;
            else
                l = pos + 1;
        }
    }

    private static int position(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1;
        int r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l, r);
                l++;
                r--;
            }
            if (nums[l] > pivot) {
                l++;
            }
            if (nums[r] < pivot) {
                r--;
            }
        }
        swap(nums, left, r);
        return r;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*
    time complexity: O(nlgk)
    space: o(k)
     */
    public static int priorityQueue(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : nums) {
            queue.add(i);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
}
