package com.github.mf.java.util.concurrent.locks;

public class ConditionTest1 {
    public static void main(String[] args) {

        ThreadA ta = new ThreadA("ta");

        // 通过synchronized(ta)获取“对象ta的同步锁”
        synchronized (ta) {
            try {
                System.out.println(Thread.currentThread().getName() + " start ta");
                ta.start();

                System.out.println(Thread.currentThread().getName() + " block");
                ta.wait();    // 等待

                System.out.println(Thread.currentThread().getName() + " continue");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class ThreadA extends Thread {

        public ThreadA(String name) {
            super(name);
        }

        public void run() {
            // 通过synchronized(this)获取“当前对象的同步锁”
            synchronized (this) {
                System.out.println(Thread.currentThread().getName() + " wakup others");
                notify();    // 唤醒“当前对象上的等待线程”
            }
        }
    }
}
