package com.e.demo_service;


/**
 * @author: majin
 * @date: 2020/4/14$
 * @desc: 自己的业务接口
 * 实现Aidl接口
 */
public interface Iservice extends IMyAidlInterface  {
    public void downLoad(String url);

    public void playMusic(String name);

    public void stop();


}
