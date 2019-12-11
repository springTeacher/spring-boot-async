package com.xiaoniu.controller;

import com.xiaoniu.service.AsyncAndSyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author lhj
 * @date 2019/12/11 11:33
 */
@RestController
@RequestMapping("/")
public class AsyncAndSyncController {


    @Autowired
    private AsyncAndSyncService asyncAndSyncService;

    /**
     * 异步没有返回值的情况
     */
    @GetMapping("async")
    public void testAsync() {
        long start = System.currentTimeMillis();
        System.err.println("异步方法开始");

        asyncAndSyncService.asyncMethod();

        System.err.println("异步方法结束");
        long end = System.currentTimeMillis();
        System.err.println("总耗时:"+(end - start));
    }

    /**
     * 异步有返回值的情况
     * 必须获取到返回值才会继续执行
     *
     * @throws ExecutionException
     * @throws InterruptedException
     * @throws TimeoutException
     */
    @GetMapping("async-return")
    public void testAsyncReturn() throws ExecutionException, InterruptedException, TimeoutException {
        long start = System.currentTimeMillis();
        System.err.println("异步方法开始");

        Future<String> stringFuture = asyncAndSyncService.asyncMethodReturn();
        String result = stringFuture.get(1, TimeUnit.SECONDS);

        System.err.println("异步方法结束，执行结果："+result);
        long end = System.currentTimeMillis();
        System.err.println("总耗时:"+(end - start));
    }



    /**
     * 同步情况
     */
    @GetMapping("sync")
    public void testSync() {
        long start = System.currentTimeMillis();
        System.err.println("同步方法开始");

        asyncAndSyncService.syncMethod();

        System.err.println("同步方法结束");
        long end = System.currentTimeMillis();
        System.err.println("总耗时："+(end - start));
    }








}
