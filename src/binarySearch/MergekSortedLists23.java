package binarySearch;

import java.util.PriorityQueue;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-04-22
 */
public class MergekSortedLists23 {
    public static void main(String[] args) {
        ListNode A1 = new ListNode(1);
        ListNode A2 = new ListNode(4);
        ListNode A3 = new ListNode(5);
        A1.next = A2;
        A2.next = A3;
        ListNode B1 = new ListNode(1);
        ListNode B2 = new ListNode(3);
        ListNode B3 = new ListNode(4);
        B1.next = B2;
        B2.next = B3;
        ListNode C1 = new ListNode(2);
        ListNode C2 = new ListNode(6);
        C1.next = C2;
        ListNode[] lists = new ListNode[]{A1, B1, C1};
        mergeKLists(lists);
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return sort(lists, 0 ,lists.length - 1);
    }
    public static ListNode sort(ListNode[] lists, int lo, int hi){
        if(lo >= hi)
            return lists[lo];
        int mid = (hi - lo)/2 + lo;
        ListNode l1 = sort(lists, lo, mid);
        ListNode l2 = sort(lists, mid + 1, hi);
        return merge(l1, l2);
    }
    /*
    Merge L1: 1->4->5
          L2: 1->3->4
    To    1->1->3->4->4->5
     */
    public static ListNode merge(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val < l2.val) {
            l1.next = merge(l1.next, l2);
            return l1;
        }
        l2.next = merge(l1, l2.next);
        return l2;
    }

    public static ListNode mergeKLists1(ListNode[] lists){
        if (lists == null || lists.length == 0) return null;
        //给queue自动排序
        /*
        eg: before: l1: 1-4-5
                    l2: 3-3-4
                    l3: 2-6
            after:  l1: 1-4-5
                    l2: 2-6
                    l3: 3-3-4
         */
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (a,b) -> a.val - b.val);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for(ListNode list: lists){
            if(list != null)
                queue.add(list);
        }
        // 取出一个最小的元素放到cur.next然后把剩余的元素放回queue里面自动进行排序！！！
        while (!queue.isEmpty()){
            cur.next = queue.poll();
            cur = cur.next;
            if(cur.next != null)
                queue.add(cur.next);
        }
        return dummy.next;
    }

}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }