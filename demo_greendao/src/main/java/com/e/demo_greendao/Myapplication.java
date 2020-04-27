package com.e.demo_greendao;

import android.app.Application;

import com.e.demo_greendao.model.DaoMaster;
import com.e.demo_greendao.model.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * @author: majin
 * @date: 2020/4/27$
 * @desc:
 */
public class Myapplication extends Application {

    public static DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        initdb();
    }

    /**
     * 连接数据库 并创建会话
     */
    public void initdb() {
        //1 获取需要连接的数据库
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "immoc.db");
       // SQLiteDatabase db = devOpenHelper.getReadableDatabase();
        Database db = devOpenHelper.getEncryptedWritableDb("123456");
        //2创建数据库连接
        DaoMaster daoMaster = new DaoMaster(db);
        //3创建数据库会话
        daoSession = daoMaster.newSession();
    }
}
