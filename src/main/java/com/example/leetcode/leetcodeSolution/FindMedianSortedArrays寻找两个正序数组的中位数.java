package com.example.leetcode.leetcodeSolution;

/**
 * 寻找两个正序数组的中位数
 *
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMedianSortedArrays寻找两个正序数组的中位数 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 1) {
            return find2(nums1, nums2, len / 2 + 1);
        } else {
            return (find2(nums1, nums2, len / 2 - 1 + 1)  + find2(nums1, nums2, len / 2 +1)) / 2.0;
        }
    }

    /**
     * 转化为求两个有序数据的第k个数
     * @param nums1
     * @param nums2
     * @param k 第n个数的坐标 从 1开始
     * @return
     */
    public static double find2(int[] nums1, int[] nums2, int k) {
        //数组指针初始化
        int index1 = 0;
        int index2 = 0;

        int len1 = nums1.length;
        int len2 = nums2.length;
        //二分中位
        int mid;
        while (true){

            //边界
            if (index1 == len1) {
                return nums2[index2 + k - 1];
            }
            if (index2 == len2) {
                return nums1[index1 + k - 1 ];
            }
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            mid = k / 2;
            //最终位置，math防止越界
            int newIndex1 = Math.min(mid + index1, len1) - 1;
            int newIndex2 = Math.min(mid + index2, len2) - 1;
            if (nums1[newIndex1] < nums2[newIndex2]) {
                k = k - (newIndex1 - index1 + 1);//计算新的k，为当前k减去移动的数量
                index1 = newIndex1 + 1;//计算新的指针，为上一次最终指针+1

            } else {
                k = k - (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,3};
        int[] nums2 = new int[]{2,4,5,6};
        double medianSortedArrays = findMedianSortedArrays(nums1, nums2);
        System.out.println("---");
    }
}
