package com.github.mf.datastructure.sort;

import java.util.Arrays;

public class BubbleSortTest {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 7, 5, 6, 9, 0};
        //int[] arr = {1, 2,3,4,5,6,7,8,9};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr) {
        boolean flag = false;
        int temp = 0;
        //控制轮次
        for (int i = 0; i < arr.length; i++) {
            //控制每趟比较数量
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            //在一趟排序中一次交换都没有发生过
            if (!flag) {
                break;
            } else {
                flag = false;
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}