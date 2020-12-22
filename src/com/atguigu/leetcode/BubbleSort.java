package com.atguigu.leetcode;

/**
 * 冒泡排序
 * 类似先1、2位比较，取最大值，再与第三个比较，再取最大值...第一轮是比较出最大值
 * 第二轮比较出第二大值
 * ...
 * 最后一轮取得倒数第二大值和最小值
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{100, 11, -12, 30, -48, 79, 1, 44};

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 -i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + "\t");
        }
    }
}
