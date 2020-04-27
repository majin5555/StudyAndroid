package com.e.demo_greendao;

import android.os.Bundle;
import android.view.View;

import com.e.demo_greendao.manager.GreenDaoManager;
import com.e.demo_greendao.model.GoodsModel;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * ORM 框架的一种  ANdroid平台的对象关系映射工具
 * 为关系型数据库提供面向对象的接口
 * 简化数据库
 * <p>
 * 优势
 * <p>
 * 性能 易用性 轻量
 */

public class MainActivity extends AppCompatActivity {

    private GreenDaoManager mDBManager;
    private GoodsAdapter    mAdapter;
    private RecyclerView    mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //查询所有的商品
        notifyAdapter(mDBManager.queryGoods());
    }

    private void init() {
        mDBManager = new GreenDaoManager(this);
        initView();
    }

    private void initView() {
        mRv = findViewById(R.id.rv);
        mAdapter = new GoodsAdapter(this);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mRv.setAdapter(mAdapter);
    }

    /**
     * 进货按钮的点击事件
     *
     * @param v
     */
    public void onAddGoodsClick(View v) {
        mDBManager.insertGoods();
    }

    /**
     * 查询全部商品
     *
     * @param v
     */
    public void onQueryAllClick(View v) {
        List<GoodsModel> dataSource = mDBManager.queryGoods();
        notifyAdapter(dataSource);
    }

    /**
     * 筛选-水果
     *
     * @param v
     */
    public void onQueryFruitsClick(View v) {
        notifyAdapter(mDBManager.queryFruits());
    }

    /**
     * 筛选-零食
     *
     * @param v
     */
    public void onQuerySnacksClick(View v) {
        notifyAdapter(mDBManager.querySnacks());
    }

    /**
     * 改变展示数据
     */
    private void notifyAdapter(List<GoodsModel> dataSource) {
        mAdapter.setDataSource(dataSource);
    }

}

