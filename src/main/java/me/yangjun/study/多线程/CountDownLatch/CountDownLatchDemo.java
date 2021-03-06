package me.yangjun.study.多线程.CountDownLatch;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

@Slf4j
public class CountDownLatchDemo {
    // 用于聚合所有的统计指标
    private static Map<String, Integer> map = new HashMap<>();
    // 创建计数器，这里需要统计4个指标
    private static CountDownLatch countDownLatch = new CountDownLatch(4);

    public static void main(String[] args) {
        //记录开始时间
        long startTime = System.currentTimeMillis();
        Thread countUserThread = new Thread(() -> {
            try {
                log.info("正在统计新增用户数量");
                TimeUnit.SECONDS.sleep(3); // 任务执行需要3秒
                map.put("userNumber", 1); // 保存结果值
                countDownLatch.countDown(); // 标记已经完成一个任务
                log.info("统计新增用户数量完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread countOrderThread = new Thread(() -> {
            try {
                log.info("正在统计订单数量");
                TimeUnit.SECONDS.sleep(5); // 任务执行需要3秒
                map.put("countOrder", 2); // 保存结果值
                countDownLatch.countDown(); // 标记已经完成一个任务
                log.info("统计订单数量完毕");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        Thread countGoodsThread = new Thread(() -> {
            try {
                log.info("正在商品销量");
                TimeUnit.SECONDS.sleep(7); // 任务执行需要3秒
                map.put("countGoods", 3); // 保存结果值
                countDownLatch.countDown(); // 标记已经完成一个任务
                log.info("统计商品销量完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread countMoneyThread = new Thread(() -> {
            try {
                log.info("正在总销售额");
                TimeUnit.SECONDS.sleep(9); // 任务执行需要3秒
                map.put("countMoney", 4); // 保存结果值
                countDownLatch.countDown(); // 标记已经完成一个任务
                log.info("统计销售额完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 启动子线程执行任务
        countUserThread.start();
        countGoodsThread.start();
        countOrderThread.start();
        countMoneyThread.start();

        try {
            // 主线程等待所有统计指标执行完毕
            countDownLatch.await();  // 阻塞当前线程，将当前线程加入阻塞队列。
            long endTime = System.currentTimeMillis(); // 记录结束时间
            log.info("------统计指标全部完成--------");
            log.info("统计结果为：" + map.toString());
            log.info("任务总执行时间为" + (endTime - startTime) / 1000 + "秒");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}