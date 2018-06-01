package math;

import java.util.PriorityQueue;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-05-31
 */
public class SuperUglyNumber313 {
    public static void main(String[] args) {
        nthSuperUglyNumber(12, new int[]{2, 7, 13, 19});
    }
    public static int nthSuperUglyNumber(int n, int[] primes) {
        int[] res = new int[n];
        res[0] = 1;
        PriorityQueue<Num> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for(int i: primes){
            pq.add(new Num(i, 1, i));
        }

        for(int i = 1; i < n; i++){
            res[i] = pq.peek().val;
            while(res[i] == pq.peek().val){
                Num next = pq.poll();
                pq.add(new Num(next.prime * res[next.index], next.index + 1, next.prime));
            }
        }
        return res[n - 1];
    }
}
class Num{
    int val;
    int index;
    int prime;

    public Num(int val, int index, int prime){
        this.val = val;
        this.index = index;
        this.prime = prime;
    }
}