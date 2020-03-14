package com.github.mf.datastructure.linkedlist;

/**
 * 约瑟夫环问题
 */
public class JosephuTest {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        System.out.println("--------------------------当前的约瑟夫环为--------------------------");
        //输出当前的环状链表
        circleSingleLinkedList.show();
    }
}


class CircleSingleLinkedList {
    Boy first = null;

    //创建小孩单向环形链表
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums错误，无法形成环状链表");
            return;
        }

        Boy currentBoy = null;
        for (int i = 1; i <= nums; i++) {
            Boy boy = new Boy(i);
            if (i == 1) {
                //first指针指向新创建的boy
                first = boy;
                //first next指向自己
                first.setNext(first);
                //currentBoy初始化为first
                currentBoy = first;
            } else {
                //将当前指针指向新创建的boy
                currentBoy.setNext(boy);
                //新创建的boy环状连接first
                boy.setNext(first);
                //当前boy指针后移到新创建的boy
                currentBoy = boy;
            }
        }
    }

    //打印输出环形链表
    public void show() {
        if (first == null) {
            System.out.println("当前链表为空链表");
            return;
        }
        Boy curBody = first;
        while (true) {
            System.out.printf("当前小孩节点为：%d",curBody.getNo());
            System.out.println();
            //如果cur指针指向first，循环结束
            if (curBody.getNext() == first) {
                break;
            }
            //指针后移
            curBody = curBody.getNext();
        }
    }
}

class Boy {
    private int no;
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
