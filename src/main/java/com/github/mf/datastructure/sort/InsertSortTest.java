package com.github.mf.datastructure.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class InsertSortTest {
    public static void main(String[] args) {
        int[] arrTest = {101, 34, 119, 1};
        //速度测试
        /*int[] arrTest = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arrTest[i] = (int) (Math.random() * 8000000);
        }

        Date date1 = new Date();
        String stringDate1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date1);
        System.out.println("开始时间："+stringDate1);
        insertSort(arrTest);
        Date date2 = new Date();
        String stringDate2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date2);
        System.out.println("结束时间："+stringDate2);*/

        insertSort(arrTest);
        System.out.println(Arrays.toString(arrTest));
    }


    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int insertValue = arr[i];
            //插入值的前一个值
            int insertIndex = i - 1;

            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;
        }
    }
}
