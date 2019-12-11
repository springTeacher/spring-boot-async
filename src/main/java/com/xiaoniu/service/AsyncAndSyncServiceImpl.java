package com.xiaoniu.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * @author lhj
 * @date 2019/12/11 11:57
 */
@Service
public class AsyncAndSyncServiceImpl implements AsyncAndSyncService{


    @Async
    @Override
    public void asyncMethod(){
        sleep();
        System.err.println("异步方法内部线程名称："+Thread.currentThread().getName());
    }


    @Async
    @Override
    public Future<String> asyncMethodReturn(){
        sleep();
        System.err.println("异步方法内部线程名称："+Thread.currentThread().getName());
        return new AsyncResult<>("hello async");
    }

    @Override
    public void syncMethod(){
        sleep();
    }


    public void sleep(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
