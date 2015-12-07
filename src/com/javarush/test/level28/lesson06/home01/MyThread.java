package com.javarush.test.level28.lesson06.home01;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sergey on 12.10.15.
 */
public class MyThread extends Thread {
    static AtomicInteger priority = new AtomicInteger(1);

    public MyThread() {
        super();
        priority.compareAndSet(11, 1);
        this.setPriority(priority.getAndIncrement());
    }

    public MyThread(Runnable target) {
        super(target);
        priority.compareAndSet(11, 1);
        this.setPriority(priority.getAndIncrement());
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        priority.compareAndSet(11, 1);
        this.setPriority(priority.getAndIncrement());
    }

    public MyThread(String name) {
        super(name);
        priority.compareAndSet(11, 1);
        this.setPriority(priority.getAndIncrement());
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);

        int maxPri = this.getThreadGroup().getMaxPriority();

        priority.compareAndSet(11, 1);

        if (priority.get() > maxPri) {
            priority.getAndIncrement();
            this.setPriority(maxPri);
        } else {
            this.setPriority(priority.getAndIncrement());
        }
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        priority.compareAndSet(11, 1);
        this.setPriority(priority.getAndIncrement());

    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);

        int maxPri = this.getThreadGroup().getMaxPriority();

        priority.compareAndSet(11, 1);

        if (priority.get() > maxPri) {
            priority.getAndIncrement();
            this.setPriority(maxPri);
        } else {
            this.setPriority(priority.getAndIncrement());
        }

    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);

        int maxPri = this.getThreadGroup().getMaxPriority();

        priority.compareAndSet(11, 1);

        if (priority.get() > maxPri) {
            priority.getAndIncrement();
            this.setPriority(maxPri);
        } else {
            this.setPriority(priority.getAndIncrement());
        }

    }
}
