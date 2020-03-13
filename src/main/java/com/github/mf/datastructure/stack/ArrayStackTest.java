package com.github.mf.datastructure.stack;

public class ArrayStackTest {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        System.out.println("栈是否为空：" + stack.isEmpty());
        System.out.println("------------------------------------------------------");
        //测试入栈
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println("入栈完毕，栈是否已满：" + stack.isFull());
        System.out.println("--------------------遍历栈--------------------");
        //遍历栈
        stack.list();
        System.out.println("--------------------数据出栈------------------");
        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println("------------------------------------------------------");
        stack.list();

    }
}


class ArrayStack {
    private int maxSize;
    private int[] stack;
    private int top = -1;


    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //出栈
    public void pop() {
        if (isEmpty()) {
            System.out.println("栈空，无数据出栈");
        }
        int value = stack[top];
        System.out.println("value:" + value);
        top--;
    }

    //入栈
    public void push(int num) {
        if (isFull()) {
            System.out.println("栈满，不可入栈");
        }
        top++;
        stack[top] = num;
    }

    //遍历栈
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，无数据");
        }

        for (int i = top; i >= 0; i--) {
            System.out.println("stack:" + stack[i]);
        }
    }
}
