package com.github.mf.java.util;

import java.util.HashMap;
import java.util.UUID;

public class HashMapTest {
    public static void main(String[] args) {
        final HashMap<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    map.put(UUID.randomUUID().toString(), "");
                }
            }).start();
            System.out.println("current thread:"+i);
        }

        /*Collections.synchronizedMap()*/
    }
}
