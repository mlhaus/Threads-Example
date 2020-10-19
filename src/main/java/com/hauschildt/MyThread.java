/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hauschildt;

/**
 *
 * @author marchauschildt
 */
public class MyThread implements Runnable {
    private Thread thread;
    
    public MyThread(String name) {
        thread = new Thread(this, name);
    }
    
    // a factory method that creates, starts, and returns a thread
    public static MyThread createAndStart(String name) {
        MyThread mt = new MyThread(name);
        mt.thread.start();
        return mt;
    }
    
    @Override
    public void run() {
        System.out.println(thread.getName() + " thread starting.");
        try {
          for (int i = 0; i < 10; i++) {
              Thread.sleep(400);
              System.out.println("In " + thread.getName() + ", count is " + i);
          }  
        } catch(InterruptedException ex) {
            System.out.println(thread.getName() + " interrupted");
        }
        System.out.println(thread.getName() + " thread ending");
    }
}
