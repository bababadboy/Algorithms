package com.gakki.basic.jvmThreadNum;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 获取jvm至少创建的线程数量
 */
public class ThreadNumDemo {
    public static void main(String[] args) {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();

        ThreadInfo[] threadInfos=threadMXBean.dumpAllThreads(false,false);
        /*
            5-Monitor Ctrl-Break
            4-Signal Dispatcher
            3-Finalizer
            2-Reference Handler
            1-main
         */
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println(threadInfo.getThreadId()+"-"+threadInfo.getThreadName());
        }
    }
}
