package array;

/**
 * This class
 *
 * @author Yi Qin
 * @date 2018-04-20
 *
 * Time : O(log(min(m,n)))
 * Space: O(1)
 *
 * example
 *         L1  R1
 * num1: 3 5 | 8 9   cut1: the number of elements of left
 *           L2  R2
 * num2: 1 2 7 | 10 11 12   cut2: the number of elements of left
 *
 * num3 : 1, 2, 3, 5, [7, 8], 9, 10, 11, 12
 * (cutL, cutR)
 * if (L1 > R2) cut1 <<  (cutL, cut1-1)
 *    (L2 > R1) cut1 >>  (cut1 + 1, cutR)
 *
 *    main idea: binary search but not the normal one
 *    change the problem from divide num3 -> num1 + num2 -> num1 (num2 cut length can be calculate form cut1)
 *
 */
public class MedianofTwoSortedArrays4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // make sure nums1 array is alway minimal length comparing nums2
        if(nums1.length > nums2.length)
            return findMedianSortedArrays(nums2, nums1);
        int len = nums1.length + nums2.length;
        int cut1 = 0;
        int cut2 = 0;
        int cutL = 0;
        int cutR = nums1.length;
        //cut1 <= nums1.length not the cutL
        while(cut1 <= nums1.length){
            cut1 = (cutR - cutL) / 2 + cutL;
            cut2 = len/2 - cut1;
            // consider about nums1 never be cut or nums2 never be cut
            double L1 = (cut1 == 0)?Integer.MIN_VALUE:nums1[cut1-1];
            double L2 = (cut2 == 0)?Integer.MIN_VALUE:nums2[cut2-1];
            double R1 = (cut1 == nums1.length)? Integer.MAX_VALUE:nums1[cut1];
            double R2 = (cut2 == nums2.length)? Integer.MAX_VALUE:nums2[cut2];
            //move left or right
            if(L1 > R2){
                cutR = cut1 - 1;
            }else if(L2 > R1){
                cutL = cut1 + 1;
            }else{
                // len is even or odd?
                if(len % 2 == 0){
                    L1 = L1 > L2 ? L1: L2;
                    R1 = R1 < R2 ? R1: R2;
                    return (L1 + R1)/2;
                }else{
                    R1 = R1 < R2 ? R1: R2;
                    return R1;
                }
            }
        }
        //handle error
        return -1;
    }

}
