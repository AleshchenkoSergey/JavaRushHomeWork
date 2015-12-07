package com.javarush.test.level28.lesson04.task01;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sergey on 06.10.15.
 */
public class AmigoThreadFactory implements ThreadFactory {

    private ThreadGroup threadGroup;
    private AtomicInteger poolNumber = new AtomicInteger(0);
    private AtomicInteger threadNumber = new AtomicInteger(0);
    private AtomicInteger currentPoolNumber;

    public AmigoThreadFactory() {
        currentPoolNumber = new AtomicInteger(poolNumber.incrementAndGet());
        threadGroup = Thread.currentThread().getThreadGroup();
    }


    @Override
    public Thread newThread(Runnable r) {
        threadNumber.incrementAndGet();
        Thread newThread = new Thread(threadGroup, r);
        String name = threadGroup.getName() + "-pool-" + currentPoolNumber + "-thread-" + threadNumber;
        newThread.setPriority(Thread.NORM_PRIORITY);
        newThread.setName(name);
        newThread.setDaemon(false);
        return newThread;
    }

}
