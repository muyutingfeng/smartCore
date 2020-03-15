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

        circleSingleLinkedList.countBoy(1, 2, 5);


    }
}


class CircleSingleLinkedList {
    Boy first = null;

    /**
     * 创建小孩单向环形链表
     *
     * @param nums 创建小孩的数量
     */
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

    /**
     * 打印输出环形链表
     */
    public void show() {
        if (first == null) {
            System.out.println("当前链表为空链表");
            return;
        }
        Boy curBody = first;
        while (true) {
            System.out.printf("当前小孩节点为：%d", curBody.getNo());
            System.out.println();
            //如果cur指针指向first，循环结束
            if (curBody.getNext() == first) {
                break;
            }
            //指针后移
            curBody = curBody.getNext();
        }
    }


    /**
     * 出圈顺序
     * <p>
     * 1：校验输入的参数是否合法(first、startNo、countNum、nums)
     * 2：创建辅助指针helper，并将helper指向环形链表的最后一个节点，即(helper.getNext()==first)时终止，否则后移循环判断
     * 3：将first和helper移动到起始节点，即移动startNo-1次
     * 4：小孩报数、移动countNum-1次，然后出圈，知道只剩下最后一个节点
     * 5：留在圈中的最后一个小孩节点出圈
     *
     * @param startNo  表示从第几个小孩开始数数
     * @param countNum 表示数几下
     * @param nums     表示最初由多少个小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        /**
         * 1：校验输入的参数是否合法(first、startNo、countNum、nums)
         */
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误，请重新输入");
            return;
        }

        /**
         * 2：创建辅助指针helper，并将helper指向环形链表的最后一个节点，即(helper.getNext()==first)时终止，否则后移循环判断
         */
        //创建辅助指针，帮助小孩出圈
        Boy helper = first;
        //指向环形链表的最后一个节点
        while (true) {
            if (helper.getNext() == first) {
                break;
            }
            helper = helper.getNext();
        }

        /**
         * 3：将first和helper移动到起始节点，即移动startNo-1次
         */
        //小孩报数前，first和helper移动startNo-1次
        for (int j = 0; j < startNo - 1; j++) {
            first = first.getNext();
            helper = helper.getNext();
        }

        /**
         * 4：小孩报数、移动countNum-1次，然后出圈，知道只剩下最后一个节点
         */
        //当小孩报数时，让first和helper指针同事移动m-1次，然后出圈
        //循环操作，直到只有一个节点
        while (true) {
            if (helper == first) {
                break;
            }
            //让first和helper指针同事移动countNum-1
            for (int j = 0; j < countNum - 1; j++) {
                first = first.getNext();
                helper = helper.getNext();
            }

            //这时first指向的节点就是要出圈的小孩节点
            System.out.printf("小孩%d出圈\n", first.getNo());

            //将first指向的小孩节点出圈
            first = first.getNext();
            helper.setNext(first);
        }

        /**
         * 5：留在圈中的最后一个小孩节点出圈
         */
        System.out.printf("最后留在圈中的小孩编号%d \n", helper.getNo());
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
