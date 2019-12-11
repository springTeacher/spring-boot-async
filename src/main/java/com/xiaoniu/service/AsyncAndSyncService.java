package com.xiaoniu.service;

import java.util.concurrent.Future;

/**
 * @author lhj
 * @date 2019/12/11 11:45
 */

public interface AsyncAndSyncService {

    void asyncMethod();

    Future<String> asyncMethodReturn();


    void syncMethod();


}
