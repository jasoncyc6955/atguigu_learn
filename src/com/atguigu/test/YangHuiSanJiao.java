package com.atguigu.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
在杨辉三角中，每个数是它左上方和右上方的数的和。
示例:
输入: 5
输出:
[
    [1],
    [1,1],
    [1,2,1],
    [1,3,3,1],
    [1,4,6,4,1]
]
*/
public class YangHuiSanJiao {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>(numRows);
        int[][] arr = new int[numRows][];
        if(numRows <= 0 ) return null;
        for (int i = 0; i < numRows; i++){
            List<Integer> childList = new ArrayList<>();
            arr[i] = new int[i + 1];
            //arr[i][0] = arr[i][i] = 1;
            //childList.add(arr[i][0]);
            //childList.add(arr[i][i]);
            for (int j = 0; j <= i; j++) {
                if(j == 0 || j == i) {
                    arr[i][j] = 1;
                }else{
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                }
                childList.add(arr[i][j]);
            }
            list.add(childList);
        }


//        for (int k = 0; k < arr.length; k++) {
//            for (int j = 0; j < arr[k].length; j++ ){
//                System.out.print(arr[k][j] + "\t");
//            }
//            System.out.println();
//        }



        return list;
    }




    public static void main(String[] args) {
        YangHuiSanJiao yangHuiSanJiao = new YangHuiSanJiao();
        List<List<Integer>> list = yangHuiSanJiao.generate(10);
        System.out.println(Arrays.toString(list.toArray()));
    }


    /**
     * 创建一个长度是6的int型数组，要求数组元素的值都在1-30之间，且是随机赋值。同时要求元素的值各不相同。
     */
}
