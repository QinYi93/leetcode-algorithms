package temp;

import java.util.HashMap;
import java.util.Timer;

/**
 * This class problem of 146
 * - get - have        update the sequence -- tail, head, middle
 *       \ don't have  -1
 *
 * - put - capacity == 0  remove the last unfrequency element
 *                        have        update value & update sequence as get
 *                        don't have  add element   1. head & tail don't exist  2. add after original tail
 *
 * data structure: in order to achieve O(1); 1. use 双向链表 （Arraylist 删除插入时候不是O(1), linklist的是，但是单项链表不能实现插入删除都是O(1)）
 *                                           2. hashmap & node
 * @author Yi Qin
 * @date 2018-05-01
 */
class LRUCache {
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null)
            return -1;
        if (node != tail) {
            if (node == head) {
                head = head.next;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        }
        return node.value;
    }

        public void put ( int key, int value){
            Node node = map.get(key);
            if (node != null) {
                node.value = value;
                if (node != tail) {
                    if (node == head) {
                        head = head.next;
                    } else {
                        node.pre.next = node.next;
                        node.next.pre = node.pre;
                    }
                    tail.next = node;
                    node.pre = tail;
                    node.next = null;
                    tail = node;
                }
            } else {
                Node newNode = new Node(key, value);
                if (capacity == 0) {
                    Node temp = head;
                    head = head.next;
                    map.remove(temp.key);
                    capacity++;
                }
                if (head == null && tail == null) {
                    head = newNode;
                } else {
                    tail.next = newNode;
                    newNode.pre = tail;
                    newNode.next = null;
                }
                tail = newNode;
                capacity--;
                map.put(key, newNode);
            }

        }
    }

    class Node {
        int key;
        int value;
        Node next;
        Node pre;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
