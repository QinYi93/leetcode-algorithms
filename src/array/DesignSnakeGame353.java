package array;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-06-03
 */
public class DesignSnakeGame353 {
    int width, height;
    int[][] food;
    //判断走到了第几个food
    int foodIndex;
    //存身体的位置方便后面从头部加入，从尾部删除
    Deque<Integer> deque;
    //用于碰撞检测，判断边界条件
    HashSet<Integer> set;
    int score;

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public DesignSnakeGame353(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        deque = new LinkedList<>();
        set = new HashSet<>();
        foodIndex = 0;
        score = 0;
        //因为从零开始所以俩个数据结构都要加入0
        set.add(0);
        deque.offerLast(0);
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if(score == -1){
            return -1;
        }
        //降维二维降一维
        int rowHead = deque.peekFirst() / width;
        int colHead = deque.peekFirst() % width;
        //要清楚是哪个增减
        switch(direction){
            case "U" : rowHead--;
                break;
            case "D" : rowHead++;
                break;
            case "L" : colHead--;
                break;
            default : colHead++;
        }
        //找到操作后头部的一维坐标
        int head = rowHead * width + colHead;
        //set要移除尾部因为向前走了一步
        set.remove(deque.peekLast());
        //case1 : 边界条件 走路的时候碰到壁了或者自己撞到自己了
        if(rowHead < 0 || rowHead == height || colHead < 0 || colHead == width || set.contains(head)) {
            return score = -1;
        }
        set.add(head);
        deque.offerFirst(head);
        //case2: 吃到了食物了这个时候尾部不用移动 score + 1 foodIndex + 1 因为刚开始把尾部删了 后面要把尾部加进去
        if(foodIndex < food.length && rowHead == food[foodIndex][0] && colHead == food[foodIndex][1]){
            foodIndex++;
            ++score;
            set.add(deque.peekLast());
            return score;
        }
        //case 3： 正常走路把尾部删除
        deque.pollLast();
        return score;
    }
}
