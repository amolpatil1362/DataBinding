package com.example.amolpatil.test;


class Factory {
     boolean flag = false;
    private int value;

    synchronized public void prod(int i) {

        if(flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println( i +" Produced");
        this.value = i;
        flag = true;
        notify();

    }

    synchronized public void cons() {

        if(!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println( value  +" Consumed");
        flag = false;
        notify();
    }
}

/**
 * Producer
 */
class Producer implements Runnable {
    private  Factory obj;


    public Producer(Factory factory) {
        this.obj = factory;
        Thread t1 = new Thread(this,"Producer");
        t1.start();
    }

    @Override
    public void run() {
        int i = 0;
        while (true){
            obj.prod(i++);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }
}


/**
 * Consumer
 */
class Consumer implements Runnable {
    private final Factory obj;

    public Consumer(Factory factory) {
        this.obj = factory;
        Thread t2 = new Thread(this,"Consumer");
        t2.start();
    }

    @Override
    public void run() {
        while (true){
            obj.cons();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }
}

public class InterThreadCommunication {

    public static void main(String[] args) {
        System.out.println("test");
        Factory factory = new Factory();

        new Producer(factory);
        new Consumer(factory);
    }


}
