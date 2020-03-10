package com.github.mf.datastructure.tree;

/**
 * 数组存储前序遍历
 */
public class ArrayBinaryTreeTest {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder(0);
    }
}

class ArrayBinaryTree {
    //存放数据
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    //前序遍历
    public void preOrder(int index) {
        if (arr.length == 0 || arr == null) {
            System.out.println("数组为空");
        }
        System.out.println(arr[index]);

        //向左递归遍历
        if (2 * index + 1 < arr.length) {
            preOrder(2 * index + 1);
        }

        //向左递归遍历
        if (2 * index + 1 < arr.length) {
            preOrder(2 * index + 2);
        }
    }
}
