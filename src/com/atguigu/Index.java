package com.atguigu;


import java.util.Arrays;

public class Index {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 3, 4,5};
        int[] arr2 = arr1;
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }
}
